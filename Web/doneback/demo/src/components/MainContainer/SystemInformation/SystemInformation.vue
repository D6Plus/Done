<template>
    <div id="sysInf">
        <div id="sysInfLeftPart">
            <div id="relatedWebsites">
                    <p
                        style="text-align: left;
                        margin-top: 0;
                        margin-bottom: 15px;
                        padding-top: 30px;
                        padding-left: 50px;
                        font-size: 25px;
                        font-weight: 600;"
                    >
                        相关网站
                    </p>
                        <div id="WebsitesTable">
                            <happy-scroll hide-horizontal color="rgba(0,0,0,0.5)" style="height: 100%;width: 100%">
                                <el-table
                                    :data="tableData"
                                    style="width: 100%">
                                <el-table-column
                                        prop="url"
                                        label="网站"
                                        width="350">
                                </el-table-column>
                                <el-table-column
                                        prop="title"
                                        label="标题"
                                        width="230">
                                </el-table-column>
                                <el-table-column
                                        prop="note"
                                        label="备注">
                                </el-table-column>
                            </el-table>
                            </happy-scroll>
                        </div>
            </div>

        </div>

    </div>
</template>

<script>
    export default {
        name: "SystemInformation",
        components:{
        },
        data() {
            return {
                tableData: [{
                    url: 'https://www.cnblogs.com/D6Plus/p/12787159.html',
                    title: 'D6 Plus博客园地址 ',
                    note: '十日冲刺计划汇总'
                }, {
                        url: '1',
                        title: '软件工程',
                        note: ' '
                }, {
                        url: '2',
                        title: '真有趣',
                        note: ''
                }  ],
            }
        }
    }
</script>
<!--<script >-->
<!--    var app = new Vue({-->
<!--        el:"#app",-->
<!--        data:{-->
<!--            label:["网站","标题","备注"]-->
<!--        }-->
<!--    })-->
<!--</script>-->
<style scoped>
#sysInf{
    width: 100%;
    height: 100%;
}
    #sysInfLeftPart{
        width: 70%;
        height: 95%;
        margin-left: 20px;
        margin-top: 20px;
        float: left;
    }
#sysInfRightPart{
    width: 27%;
    height: 95%;
    box-shadow: 1px 1px 3px #888888;
    margin-left: 20px;
    margin-top: 20px;
    float: left;
}
    #relatedWebsites{
        margin-top: 0;
        width: 100%;
        height: 49%;
        box-shadow: 1px 1px 3px #888888;
    }
    #aboutSystem{
        width: 100%;
        height: 49%;
        margin-top: 20px;
        box-shadow: 1px 1px 3px #888888;
    }
    #WebsitesTable{
        margin-left: 50px;
        margin-bottom: 20px;
        margin-right: 50px;
        height: 65%;
    }
#WebsitesTable>>>.happy-scroll-content{
    width: 100%
}
.sysInfItemCard{
    font-size: 16px;
}
    .sysInfItemTitle{
        float: left;
        color: #999999;
    }
    .sysInfItem{
        color: #333333;
        float: left;
    }
    .sysInfItemCard{
        width: 100%;
    }
.sysInfItemLittleCard{
    width: 100%;
    height: 30px;
    float: left;
    margin-top: 10px;
}
</style>
