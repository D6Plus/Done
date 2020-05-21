<template>
    <div class="login_container">
        <div class="login_box">
            <!-- 登录表单区域 -->
            <el-form size="mini">
                <!-- 用户名 -->
                <el-form-item>
                    <el-input placeholder="用户名" v-model="newPerson.name"></el-input>
                </el-form-item>
                <!-- 密码 -->
                <el-form-item>
                    <el-input placeholder="密码" show-password v-model="newPerson.pwd"></el-input>
                </el-form-item>
                <!-- 记住我 -->
                <el-form-item>
                    <el-checkbox label="记住我" class="rememberMe"></el-checkbox>
                </el-form-item>
                <!-- 登录按钮 -->
                <el-form-item>
                    <el-button type="primary" @click="register()">登录</el-button>
                </el-form-item>
            </el-form>
        </div>
        <vue-particles
                color="#fff"
                :particleOpacity="0.7"
                :particlesNumber="60"
                shapeType="circle"
                :particleSize="4"
                linesColor="#fff"
                :linesWidth="1"
                :lineLinked="true"
                :lineOpacity="0.4"
                :linesDistance="150"
                :moveSpeed="2"
                :hoverEffect="true"
                hoverMode="grab"
                :clickEffect="true"
                clickMode="push"
                class="lizi"
                style="height:100%"
        >
        </vue-particles>
    </div>
</template>
<script>
    import MainContainer from "./MainContainer/MainContainer";
    export default {
        data() {
            return{
                name:123123,
                pwd: 'asdasd',
                newPerson:{name:'',pwd:''}
            }
        },
        methods: {
            register(){
                console.log(MainContainer.data().content)
                MainContainer.data().content='SystemInformation'
                console.log(MainContainer.data().content)
                }
            }

        }
</script>

<style scoped>
    .login_container {
        background-image: linear-gradient(-180deg, #1a1454 0%, #0e81a5 100%);
        /*background-image: url("../images/bg_login.png");*/
        background-repeat: no-repeat;
        background-size: cover;
        height: 100%;
    }
    .login_box {
        width: 290px;
        height: 350px;
        /* background-color: #fff; */
        background-color: #2e527bb3;
        border-radius: 5px;

        position: absolute;
        left: 50%;
        top: 50%;
        transform: translate(-50%, -50%);
    }
    .el-form {
        padding: 32px;
        position: absolute;
        bottom: 0;
        width: 100%;
        box-sizing: border-box;
    }
    .el-button {
        width: 100%;
    }

    img {
        /* style="width: 100px; height: 30px; margin-left:5px;vertical-align: middle;" */
        display: inline-block;
        width: 45%;
        height: 28px;
        margin-left: 10px;
        vertical-align: middle;
        border-radius: 3px;
    }
    .rememberMe {
        color: #fff;
    }
</style>