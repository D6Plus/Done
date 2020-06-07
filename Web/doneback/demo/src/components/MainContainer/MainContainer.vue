<template>
    <div id="mainContainer">
        <component :is="content"/>
    </div>
</template>

<script>
    import { EventBus } from '../../tools/EventBus'
    import SystemInformation from '../../components/MainContainer/SystemInformation/SystemInformation'
    import UserList from '../../components/MainContainer/UserList/UserList'
    import PersonalPlanList from '../../components/MainContainer/PlanList/PersonalPlanList'
    import GroupPlanList from '../../components/MainContainer/PlanList/GroupPlanList'
    import GroupManage from '../../components/MainContainer/GroupManage/GroupManage'
    import login from "./login"
    export default {
        name: "MainContainer",
        components:{
            SystemInformation,
            GroupManage,
            UserList,
            PersonalPlanList,
            GroupPlanList,
            login
        },
        data(){
            return{
                content:'login'
            }
        },
        mounted() {
            EventBus.$on('selectFunctionModule',(msg)=>{
                console.log("点击"+msg+"模块");
                switch (msg) {
                    case '用户列表':
                        this.content='UserList';
                        break;
                    case '系统信息':
                        this.content='SystemInformation';
                        break;
                    case '个人计划':
                        this.content='PersonalPlanList';
                        break;
                    case '小组计划':
                        this.content='GroupPlanList';
                        break;
                    case '小组管理':
                        this.content='GroupManage';
                        break;
                }
            })
        }
    }
</script>

<style scoped>
#mainContainer{
    width: 100%;
    height: 100%;
    background-color: #fbfbfb;
}
</style>
