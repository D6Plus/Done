<template>
  <div id="sideMenu">
    <el-collapse
      :accordion="accordion"
      style="margin-left: 20px;margin-right: 20px;padding-top: 30px"
      v-model="activeNames">
      <el-collapse-item
        v-for="(functionModule,index) in this.functionModuleNames"
        :key="index"
        :name=index
        :title="functionModule.mainModuleName"
      >
        <div
          v-for="(subFunctionModule,index) in functionModule.subFunctionModule"
          :key="index"
          @click="selectFunctionModule(subFunctionModule)"
          class="subFunctionModule"
        >
          {{subFunctionModule}}
        </div>
      </el-collapse-item>
    </el-collapse>
  </div>
</template>

<script>
  import { EventBus } from '../../tools/EventBus'
  export default {
    name: "SideNavigation",
    data(){
      return{
        accordion:false, // true打开手风琴模式
        activeNames: ['1','2','3'],
        functionModuleNames:[
          {
            mainModuleName:'首页',
            subFunctionModule:['日历','通知']
          },
          {
            mainModuleName:'计划',
            subFunctionModule:['我的计划']
          },
          {
            mainModuleName:'小组',
            subFunctionModule:['我的小组']
          }
        ]
      }
    },
    methods:{
      selectFunctionModule(name){
        EventBus.$emit('selectFunctionModule',name);
      }
    }
  }
</script>

<style scoped>
  #sideMenu{
    width: 100%;
    height: 100%;
    background-color: #f5f5f7;
  }
  #sideMenu>>>.el-collapse-item__header{
    font-size: 16px;
    font-weight: 500;
    background-color: #f5f5f7;
    color: #8f99a5;
  }
  #sideMenu>>>.el-collapse-item__header:hover{
    color: #333333;
  }
  #sideMenu>>>.el-collapse-item__content{
    padding-left: 20px;
    cursor: default;
    text-align: left;
    font-size: 16px;
    font-weight: 500;
    background-color: #f5f5f7;
    color: #8f99a5;
  }
  .subFunctionModule:hover{
    color: #333333;
  }
</style>
