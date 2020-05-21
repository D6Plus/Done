<template>
  <div id="headTop">
    <el-container>
      <el-header style="text-align: left; font-size: 12px; margin-top: 20px">
        <p style="font-family: 微軟正黑體 ; margin-top:0px;color: #535353"><font size="4">
          Done--你的计划管理工具</font></p>
        <el-dropdown>
          <i class="el-icon-setting" style="margin-right: 15px"></i>
          <el-dropdown-menu slot="dropdown">
            <el-dropdown-item @click="selectFunctionModule()"
                              v-for="(item,index) in this.itemsName " :key="index">{{item.name}}</el-dropdown-item>
          </el-dropdown-menu>
        </el-dropdown>
        <span>{{username}}</span>
      </el-header>
    </el-container>
  </div>
</template>

<script>
    import {EventBus} from "../../tools/EventBus";

    export default {
        name: "HeadTop",
        data(){
          return{
            username:'LMG',
            index:'',
            name:'',
            itemsName:[
              {name:'信息', index:'1'},
              {name:'设置', index:'2'},
              {name:'退出', index:'3'}
            ]
          }
        },
      methods: {
        selectFunctionModule(name) {
          EventBus.$emit('selectFunctionModule', name);
        }
      }
    }
</script>

<style scoped>
  #headTop{
    background-color:#B3C0D1;
  }
</style>
