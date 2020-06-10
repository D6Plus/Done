<template>
  <div id="managePlan" style="display: inline">
    <div id="myPlan" style="display: inline-block;float: left">
      <el-card class="box-card1" style="width: 700px;">
        <div slot="header" class="clearfix">
          <span>计划一览</span>
        </div>
        <br>
        <el-input id="inputid" v-model="input1" maxlength="10" placeholder="请输入要进行操作的计划序号"></el-input>
        <el-button @click="editPlanInfo">编辑</el-button>
        <!--先用getPlanById获取具体信息填充默认输入框 然后更改计划后调用updatePlan -->
        <el-popconfirm title="确定删除这个计划吗？" @onConfirm="del(getIndex())">
          <el-button slot="reference">删除</el-button>
        </el-popconfirm>
        <div v-for="item in list" :key="index" class="text item">
          <p>计划序号 :{{item.index}}</p>
          <p>计划名称 :</p>
          <el-input v-model=item.name></el-input>
          <p>发布时间 :</p>
          <el-input v-model=item.value1></el-input>
          <p>截止时间 :</p>
          <el-input v-model=item.value2></el-input>
          <p>计划详细内容 :</p>
          <el-input
            type="textarea"
            :rows="10"
            v-model=item.planinfo>
          </el-input>
          <br><br>
        </div>
      </el-card>
    </div>
    <div id="createPlan" style="display: inline-block;float: left">
      <el-card class="box-card2" style="width: 580px">
        <div slot="header" class="clearfix">
          <span>新建计划</span>
        </div>
        <div class="text item">
          <p>计划名称:</p>
          <el-input v-model="newinput" placeholder="请输入计划名称"></el-input>
          <p>发布时间:</p>
          <el-date-picker
            v-model="value1"
            type="datetime"
            placeholder="选择日期时间">
          </el-date-picker>
          <p>截止时间:</p>
          <el-date-picker
            v-model="value2"
            type="datetime"
            placeholder="选择日期时间">
          </el-date-picker>
          <span class="demonstration"></span>
          <p>计划详细内容:</p>
          <el-input
            type="textarea"
            :rows="10"
            placeholder="请输入内容"
            v-model="textarea">
          </el-input>
          <p></p>
          <el-button :plain="true" style="display:inline-block;float: right" @click="add()">点击新建</el-button>
          <p>&nbsp;</p>
        </div>
      </el-card>
    </div>
  </div>
</template>

<script>
    import index from "../../../router";
    export default {
      name: "ManagePlan",
      data(){
        return{
          inputindex:'',
          input1:'',
          value1:'',
          value2:'',
          newinput:'',
          textarea:'',
          name:'',
          planinfo:'',
          index:'',
          list:[
            {name:'软件工程alpha冲刺',value1:'2020-04-27',value2:'2020-05-07',
              planinfo:'完成项目的alpha测试阶段与相应博客和文档内容',index:'1'
            },
            {name:'JavaEE作业',value1:'2020-04-27',value2:'2020-05-07',
              planinfo:'运用Spring框架的事务支持功能和Hibernate通用DAO，实现订单管理(订单列表、发货)业务，并实现日志功能',index:'2'},
            {name:'创新创业网课学习',value1:'2020-03-15',value2:'2020-05-30',
              planinfo:'完成超星网上相应课程',index:'3'},
            {name:'保留',value1:'2020-12-31',value2:'2021-01-01',
              planinfo:'暂无安排',index:'4'}
          ]
        }
      },
      created() {
        this.$nextTick(function () {
          var inputindex = document.getElementById('inputid');
        })
      },
      methods:{
        add(){
          this.list.push({name:this.input,value1:this.value1,value2:this.value2,planinfo:this.textarea,index:this.list.length+1})
          this.$message({
            message: '新建计划成功！',
            type: 'success'
          });
        },
        getIndex(){
          var index1 = document.getElementById('inputid').value;
          return index1;
        },
        del(index){
          var index = this.list.findIndex(item => {
            if(item.index == index){
              return true;
            }
          })
          this.list.splice(index,1)
        },
        editPlanInfo(index){
          var index = this.list.findIndex(item => {
            if(item.index == index){
              return true;
            }
          })
        },
        confirm(){
          this.visible = false;
          this.$emit('onConfirm');
        }
      }
    }
</script>

<style>
  .text {
    font-size: 14px;
  }

  .item {
    margin-bottom: 18px;
  }

  .clearfix:before,
  .clearfix:after {
    display: table;
    content: "";
  }
  .clearfix:after {
    clear: both
  }

</style>
