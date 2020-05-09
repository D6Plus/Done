<template>
    <div id="sideNav">
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
                accordion:true, // 这是手风琴开关，设为true能打开手风琴模式
                activeNames: ['1','2','3'],
                functionModuleNames:[
                    {
                        mainModuleName:'小组管理',
                        subFunctionModule:['小组管理']
                    },
                    {
                        mainModuleName:'计划管理',
                        subFunctionModule:['个人计划','小组计划']
                    },
                    {
                        mainModuleName:'用户管理',
                        subFunctionModule:['用户列表']
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
#sideNav{
    width: 100%;
    height: 100%;
    background-color: #f5f5f7;
}
#sideNav>>>.el-collapse-item__header{
    font-size: 16px;
    font-weight: 500;
    background-color: #f5f5f7;
    color: #8f99a5;
}
#sideNav>>>.el-collapse-item__header:hover{
    color: #333333;
}
#sideNav>>>.el-collapse-item__content{
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
