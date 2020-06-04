<template>
    <div class="container" style="width: 1200px;">

        <div class="filter-container">

            <div class="letf-items" style="float: left;">
                <el-input
                        placeholder="模糊查询"
                        style="width: 200px;"
                        class="filter-item"
                        v-model="searchTableInfo"/>
            </div>
            <div class="right-items" style="float: right;">
                <el-button round size="primary" icon="el-icon-edit" @click="editAll">批量编辑</el-button>
                <el-button round size="primary" icon="el-icon-upload" type="success" @click="submit">批量提交</el-button>
<!--                <el-button round size="primary" icon="el-icon-plus" @click="addAll">批量新增</el-button>-->
                <el-button round size="primary" icon="el-icon-delete" type="danger" @click="delectAll">批量删除</el-button>            </div>
        </div>

        <!--                    描述：列表展示-->

        <el-table border
                  :data="userListtable.slice((currentPage-1)*pageSize, currentPage*pageSize)"
                  @selection-change="handleSelectionChange"
                  :default-sort = "{prop: 'userName', order: 'descending'}">
            <el-table-column type="selection"></el-table-column>

            <el-table-column label="用户ID"  sortable>
                <template slot-scope="scope">
                    <span v-if="scope.row.show">
                        <el-input size="mini" placeholder="请输入序号" v-model="scope.row.userID"></el-input>
                    </span>
                    <span v-else>{{scope.row.userID}}</span>
                </template>
            </el-table-column>

            <el-table-column label="用户名"  sortable>
                <template slot-scope="scope">
                    <span v-if="scope.row.show">
                        <el-input size="mini" placeholder="请输入序号" v-model="scope.row.userName"></el-input>
                    </span>
                    <span v-else>{{scope.row.userName}}</span>
                </template>
            </el-table-column>

            <el-table-column label="用户密码" sortable>
                <template slot-scope="scope">
                        <span v-if="scope.row.show">
                            <el-input size="mini" placeholder="请输入计划名" v-model="scope.row.pwd"></el-input>
                        </span>
                    <span v-else>{{scope.row.pwd}}</span>
                </template>
            </el-table-column>

            <el-table-column label="权限"  sortable>
                <template slot-scope="scope" >
                    <el-select v-model="scope.row.opt" placeholder="请选择" size="mini" @change="changeSelect($event,scope.row)" >
                        <el-option
                                v-for="item in options"
                                :key="item.value"
                                :label="item.label"
                                :value="item.value"
                                :disabled="item.disabled">
                        </el-option>
                    </el-select>
                </template>
            </el-table-column>

            <el-table-column label="操作">
                <template slot-scope="scope">
                    <el-button-group>
                        <el-button round size="mini" icon="el-icon-edit" @click="edit(scope.row,scope.$index)">{{scope.row.show?'保存':"修改"}}</el-button>
                        <el-button round size="mini" icon="el-icon-delete" type="danger" @click="delect(scope.$index)">删除</el-button>
                    </el-button-group>
                </template>
            </el-table-column>

        </el-table>

        <el-pagination class="fy"
                       layout="sizes, prev, pager, next, total, jumper"
                       @current-change="currentChange"
                       @size-change="handleSizeChange"
                       :page-sizes="[4,6,8,10,12]"
                       :page-size="pageSize"
                       :total="tabledatas.length"
                       background>
        </el-pagination>

        <el-dialog title="提示" :visible.sync="delVisible" width="300px" center>
            <div class="del-dialog-cnt">删除不可恢复，是否确定删除？</div>
            <span slot="footer" class="dialog-footer">
                    <el-button @click="delVisible = false">取 消</el-button>
                    <el-button type="primary" @click="delVisible = false" >确 定</el-button>
                </span>
        </el-dialog>

    </div>
</template>
<script>
    import Vue from 'vue'
    export default {
        data() {
            return {
                searchTableInfo:"",//模糊查询关键词
                // total:1000,//默认数据总数
                pageSize:6,//每页的数据条数
                currentPage:1,//默认开始页面
                delVisible:false,//删除提示弹框的状态
                tabledatas: [],//表格数据存储处
                tempForm: {
                    userID: '',
                    userName: '',
                    pwd: '',
                    options: ''
                },
                options: [{
                    value: '0',
                    label: '用户',
                    disabled: false
                }, {
                    value: '1',
                    label: '管理员'
                }],
                multipleSelection: []
            }
        },
        computed: {
            // 根据计算属性模糊搜索
            userListtable () {
                const searchTableInfo = this.searchTableInfo
                if (searchTableInfo) {
                    return this.tabledatas.filter(data => {
                        console.log("success"+data)
                        return Object.keys(data).some(key => {
                            return String(data[key]).toLowerCase().indexOf(searchTableInfo) > -1
                        })
                    })
                }
                return this.tabledatas
            }
        },
        created() {
            //this.tabledatas = []
            this.tabledatas = [{
                userID: "01",
                userName: "aaa",
                pwd: "测试1",
                opt:"0",
            }, {
                userID: "02",
                userName: "bbb",
                pwd: "测试1",
                opt:"0",
            }, {
                userID: "03",
                userName: "ccca",
                pwd: "测试1",
                opt:"0",
            }, {
                userID: "04",
                userName: "ddd",
                pwd: "测试1",
                opt:"0",
            }, {
                userID: "05",
                userName: "eeeafda",
                pwd: "测试1",
                opt:"0",
            }, {
                userID: "06",
                userName: "sdafasd asfsadfsda",
                pwd: "测试1",
                opt:"1",
            }, {
                userID: "015",
                userName: "aafsadfdsfasfa",
                pwd: "sdafadfas",
                opt:"1",
            }, {
                userID: "017",
                userName: "asdfafdafaa",
                planName: "sadfssssssssssssss",
                opt:"1",
            }]

            this.tabledatas.map(i => {
                i.show = false
                return i
            })
            //this.total=this.tableData.length;
            //this.getList();
        },
        methods: {
            //与后端通信获取数据
            getList(){
                // axios.post('/getProName/',{
                //     page:this.current_page,
                //     page_size:10
                // })
                //     .then((response) => {
                //         // 响应体
                //         this.res = response.data;
                //         // 返回数据
                //         this.tabledatas = this.res.data.projects;
                //         // 页数
                //         this.pro_pages = 10 * this.res.data.total_pages;
                //     })
                //     .catch((error) => {
                //         console.log(error);
                //     });
            },
            //选择
            handleSelectionChange(val) {
                this.multipleSelection = val
            },
            handleSizeChange(pageSize) {
                this.pageSize = pageSize;
            },
            currentChange(currentPage){
                this.currentPage = currentPage
            },
            //处理分页后index不准确的问题
            trueIndex(index) {
                this.index = index + (this.currentPage - 1) * this.pageSize
                return this.index
            },
            //下拉框事件
            changeSelect(event,row){
                console.log("选项代号："+event+ " row.opt :"+row.opt)
                //在这里修改每行的opt
                // console.log("事件是："+event.index)
            },
            edit(row, index) {
                //用row可以获取该行所有属性值
                console.log("index："+index+ "    row.userID:"+row.userID +"    row.opt:"+row.opt)
                row.show = row.show ? false : true
                Vue.set(this.tabledatas, this.trueIndex(index), row)
                // 修改后保存
                //axios.post
            },
            editAll() {
                this.tabledatas.map((i, index) => {
                    i.show = true
                    Vue.set(this.tabledatas, index, i)
                })
                //axios.post
            },
            submit() {
                this.tabledatas.map((i, index) => {
                    i.show = false
                    Vue.set(this.tabledatas, index, i)
                })
                //axios.post
            },
            // 单个复制
            cope(val, index) {
                this.tabledatas.splice(index, 0,JSON.parse(JSON.stringify(val)))
                //axios.post
            },
            // 单个删除
            delect(index) {
                this.tabledatas.splice(index, 1)
                //this.delVisible = true
                //axios.post
            },
            //批量新增
            // addAll() {
            //     if (this.multipleSelection.length == 0) {
            //         let list = {
            //             title: "",
            //             text: ""
            //         }
            //         this.tabledatas.push(list)
            //     } else {
            //         this.multipleSelection.forEach((val, index)=> {
            //             this.tabledatas.splice(index, 0,JSON.parse(JSON.stringify(val)))
            //         });
            //     }
            //     //axios.post
            // },

            //批量删除
            delectAll() {
                for (let i = 0; i < this.tabledatas.length; i++) {
                    const element = this.tabledatas[i];
                    element.id = i
                }
                if (this.multipleSelection.length == 0) this.$message.error('请先至少选择一项')
                this.multipleSelection.forEach(element => {
                    this.tabledatas.forEach((e, i) => {
                        if (element.id == e.id) {
                            this.tabledatas.splice(i, 1)
                        }
                    });
                });
                //axios.post
            }
        },
    }
</script>
<style>
    .container {
        padding: 15px 32px;
        margin: 4px 2px;
    }
    .fy{
        text-align:center;
        margin-top:30px;
    }
</style>