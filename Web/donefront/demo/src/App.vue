<template>
  <div id="app">
    <el-container>
      <!-- 页头 -->
      <el-header style="padding: 0;height: 50px;z-index: 100">
        <HeadTop></HeadTop>
      </el-header>
      <el-container>
        <!-- 侧边菜单栏 -->
        <el-aside width="200px" height="100%" >
          <SideMenu></SideMenu>
        </el-aside>
        <!-- 主容器 -->
        <el-main style="margin-top:20px; padding: 0; overflow-y: hidden">
          <FrontMain></FrontMain>
        </el-main>
      </el-container>
    </el-container>
  </div>
</template>

<script>
import FrontMain from "./components/MainContent/FrontMain";
import SideMenu from "./components/SideMenu/SideMenu";
import HeadTop from "./components/HeadTop/HeadTop";
export default {
  name: 'App',
  components:{
    SideMenu,
    HeadTop,
    FrontMain
  }
}
</script>

<style>
  #app {
    font-family: Avenir, Helvetica, Arial, sans-serif;
    -webkit-font-smoothing: antialiased;
    -moz-osx-font-smoothing: grayscale;
    color: #2c3e50;
    height: 100%;
    position: absolute;
    top: 0;
    left: 0;
    width: 100%;
    max-width: 1920px;
  }
</style>
