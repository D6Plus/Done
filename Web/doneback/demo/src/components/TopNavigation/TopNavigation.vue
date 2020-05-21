<template>
    <div id="topNav">
        <el-row :gutter="24">
            <el-col :span="15">
                <div style="text-align: left;float: left">
                    <p id="topNavTitle">Done</p>
                </div>
                <el-input
                        style="margin-top: 5px;width: 300px;float: left;margin-left: 10px;"
                        placeholder="这里可以输入内容"
                        prefix-icon="el-icon-search"
                        v-model="searchInput"
                >
                </el-input>
            </el-col>
            <el-col :span="9"></el-col>
            <el-col :span="1"></el-col>
        </el-row>
    </div>
</template>

<script>
    // import BusinessCard from '../TopNavigation/BusinessCard'
    export default {
        name: "TopNavigation",
        data(){
            return{
                searchInput:''
            }
        },
        components:{
            // eslint-disable-next-line vue/no-unused-components
            //BusinessCard
        }
    }
</script>

<style scoped>
#topNav{
    height: 100%;
    width: 100%;
    background-color: #399fc1;
    overflow: hidden;
}
#topNav>>>.el-input__inner{
    background-color: #5b68ce;
    border: 1px solid #5b68ce;
    color: #ffffff;
}
    #topNavTitle{
        color: #ffffff;
        font-weight: 600;
        font-size: 20px;
        margin: 10px 15px;
    }
</style>
