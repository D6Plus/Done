<template>
  <div id="userGroup">
    <!-- 数据调用
    <div v-for="item in groupList" :key="groupID" class="textoutput">
      <p>小组ID:{{item.groupID}}</p>
      <p>小组名:{{item.groupName}}</p>
      <p>小组详情:{{item.groupDescribe}}</p>
    </div>
    -->
    <div id="groupListView">
      <el-carousel :interval="4000" type="card" height="200px">
        <el-carousel-item v-for="item in InfoList" :key="groupID" style="margin-top: 25px">
          <h3 class="medium" style="text-align: center">{{ item.groupName }} -- {{ item.groupDescribe }}</h3>
        </el-carousel-item>
      </el-carousel>
    </div>
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
        },
        InfoList:[
          {groupName:'软工小组',groupDescribe:'软件工程实践作业',groupID:'1'},
          {groupName:'人机交互小组',groupDescribe:'人机交互课程大作业',groupID:'2'},
          {groupName:'软件项目管理小组',groupDescribe:'软件项目管理大作业',groupID:'3'},
          {groupName:'算法小组',groupDescribe:'算法2020大作业',groupID:'4'}
        ]
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
