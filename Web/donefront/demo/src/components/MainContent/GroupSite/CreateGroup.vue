<template>
  <div id="createGroup">
    <div v-for="item in groupList" :key="groupID" class="textoutput">
      <p>小组ID:{{item.groupID}}</p>
      <p>小组名:{{item.groupName}}</p>
      <p>小组详情:{{item.groupDescribe}}</p>
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

</style>
