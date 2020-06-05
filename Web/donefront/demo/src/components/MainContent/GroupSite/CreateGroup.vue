<template>
  <div id="createGroup">
    <!-- 数据调用
    <div v-for="item in groupList" :key="groupID" class="textoutput">
      <p>小组ID:{{item.groupID}}</p>
      <p>小组名:{{item.groupName}}</p>
      <p>小组详情:{{item.groupDescribe}}</p>
    </div>
    -->
    <el-carousel :interval="4000" type="card" height="200px">
      <el-carousel-item v-for="item in 6" :key="item" style="margin-top: 25px">
        <h3 class="medium">{{ item }}</h3>
      </el-carousel-item>
    </el-carousel>
  </div>
</template>

<script>
  import axios from 'axios'
    export default {
      name: "CreateGroup",
      data(){
        return{
          groupName:'',
          groupDescribe:'',
          groupID:'',
          groupList:{
            groupName:'',
            groupDescribe:'',
            groupID:''
          }
        }
      },
      mounted() {
        this.getData();
      },
      methods: {
        getData(){
          axios.get('/Group/queryAllGroup').then(response => {
            this.groupList = response.data;
            console.log(typeof (response.data));
          },response => {
            console.log("error");
          });
        }
      }
    }
</script>

<style scoped>
  .el-carousel__item h3 {
    color: #475669;
    font-size: 14px;
    opacity: 0.75;
    line-height: 200px;
    margin: 0;
  }

  .el-carousel__item:nth-child(2n) {
    background-color: #99a9bf;
  }

  .el-carousel__item:nth-child(2n+1) {
    background-color: #d3dce6;
  }
</style>
