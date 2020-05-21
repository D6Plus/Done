<template>
  <div id="calendar">
    <el-calendar>
      <!-- 这里使用的是 2.5 slot 语法-->
      <template
        slot="dateCell"
        slot-scope="{date, data}">
        <p :class="data.isSelected ? 'is-selected' : ''">
          {{ data.day.split('-').slice(1).join('-') }} {{ data.isSelected ? '✔️' : ''}}
        </p>
      </template>
    </el-calendar>
    <p style="margin-left: 5px;margin-top: -10px">信息摘要：预计beta版本完成此功能</p>
  </div>
</template>

<script>
    export default {
        name: "Calendar"
    }
</script>

<style scoped>
  .is-selected {
    color: #1989FA;
  }
</style>
