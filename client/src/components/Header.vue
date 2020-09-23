<template>
  <header class="header">
    <router-link id="logo" to="/">TodoList</router-link>
    <div id="nav">
      <router-link to="/about">About</router-link>
    </div>
  </header>
</template>

<script>
export default {
  name: 'Header',
}
</script>

<style scoped>
.header {
  background: #333;
  color: #fff;
  text-align: center;
  padding: 10px;
}
.header a {
  color: #fff;
  text-decoration: none;
}
#logo {
  font-size: 2rem;
  font-weight: bold;
}
</style>
