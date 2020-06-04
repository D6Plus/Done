<template>
  <div id="managePlan" style="display: inline">
    <div id="myPlan" style="display: inline-block;float: right">
      <el-card class="box-card" style="width: 800px;">
        <div slot="header" class="clearfix">
          <span>计划一览</span>
        </div>
        <div v-for="item in list" :key="index" class="text item">
          <p>计划名称 : {{item.index}}.{{item.name}}</p>
          <p>发布时间 : {{item.value1}}</p>
          <p>截止时间 : {{item.value2}}</p>
          <p>计划详细内容 : {{item.planinfo}}</p>
          <el-popconfirm title="确定删除这个计划吗？" @onConfirm="del(item.index)">
            <el-button slot="reference">删除</el-button>
          </el-popconfirm>
        </div>
      </el-card>
    </div>
    <div id="createPlan" style="display: inline-block;float: left">
      <el-card class="box-card" style="width: 480px">
        <div slot="header" class="clearfix">
          <span>新建计划</span>
          <el-button :plain="true" @click="add()">点击新建</el-button>
        </div>
        <div class="text item">
          <p>计划名称:</p>
          <el-input v-model="input" placeholder="请输入计划名称"></el-input>
          <p>发布时间:</p>
          <el-date-picker
            v-model="value1"
            type="date"
            placeholder="选择日期"
            format="yyyy 年 MM 月 dd 日"
            value-format="yyyy-MM-dd">
          </el-date-picker>
          <p>截止时间:</p>
          <el-date-picker
            v-model="value2"
            type="date"
            placeholder="选择日期"
            format="yyyy 年 MM 月 dd 日"
            value-format="yyyy-MM-dd">
          </el-date-picker>
          <span class="demonstration"></span>
          <p>计划详细内容:</p>
          <el-input
            type="textarea"
            :rows="10"
            placeholder="请输入内容"
            v-model="textarea">
          </el-input>
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
          value1:'',
          value2:'',
          input:'',
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
      methods:{
        add(){
          this.list.push({name:this.input,value1:this.value1,value2:this.value2,planinfo:this.textarea,index:this.list.length+1})
          this.$message({
            message: '新建计划成功！',
            type: 'success'
          });
        },
        del(index){
          var index = this.list.findIndex(item => {
            if(item.index == index){
              return true;
            }
          })
          this.list.splice(index,1)
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
