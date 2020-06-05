<template>
  <div id="frontMain">
    <component :is="content"/>
  </div>
</template>

<script>
  import { EventBus } from "../../tools/EventBus";
  import JoinGroup from "./GroupSite/JoinGroup";
  import UsersGroup from "./GroupSite/UsersGroup";
  import ManagePlan from "./PlanSite/ManagePlan";
  import Calendar from "./HomeSite/Calendar";
  import InfoNotes from "./HomeSite/InfoNotes";

  export default {
  name: 'FrontMain',
  components:{
    JoinGroup,
    UsersGroup,
    ManagePlan,
    Calendar,
    InfoNotes
  },
  data () {
    return {
      content:'Calendar'
    }
  },
  mounted() {
    EventBus.$on('selectFunctionModule',(msg)=>{
      console.log("点击"+msg+"模块");
      switch (msg) {
        case '日历':
          this.content="Calendar"
          break;
        case '通知':
          this.content="InfoNotes";
          break;
        case '我的计划':
          this.content="ManagePlan";
          break;
        case '我的小组':
          this.content="UsersGroup";
          break;
        case '创建小组':
          this.content="CreateGroup";
          break;
        case '加入小组':
          this.content="JoinGroup";
          break;
      }
    })
  }
  }
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
</style>
