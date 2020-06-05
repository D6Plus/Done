<template>
  <div id="app">
    <el-container style="height: 100%">

      <!--顶部导航-->
      <el-header style="padding: 0;height: 50px;z-index: 100">
        <TopNavigation></TopNavigation>
      </el-header>

      <el-container style="height: 100%">

        <!--侧边导航-->
        <el-aside width="200px" style="height: 100%;" >
          <SideNavigation></SideNavigation>
        </el-aside>

        <!--主容器-->
        <el-main style="padding: 0">
          <MainContainer></MainContainer>
        </el-main>
      </el-container>
    </el-container>
  </div>
</template>

<script>
// import HelloWorld from './components/HelloWorld.vue'
import TopNavigation from './components/TopNavigation/TopNavigation'
import SideNavigation from './components/SideNavigation/SideNavigation'
import MainContainer from './components/MainContainer/MainContainer'

export default {
  name: 'App',
  components: {
    // eslint-disable-next-line vue/no-unused-components
    // HelloWorld,
    TopNavigation,
    SideNavigation,
    MainContainer
  }
}
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  height: 100%;
  position: absolute;
  top: 0;
  left: 0;
  width: 100%;
}
</style>
