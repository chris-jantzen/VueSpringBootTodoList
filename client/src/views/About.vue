<template>
  <div class="container">
    <h1>Todo List App</h1>
    <p>Implements</p>
    <ul>
      <li><a href="https://vuejs.org/" target="_blank">VueJS</a></li>
      <li><a href="https://spring.io/" target="_blank">Java Spring</a></li>
      <li>
        <a href="https://www.postgresql.org/" target="_blank">PostgreSQL</a>
      </li>
    </ul>
    <a href="https://github.com/jantzeca/VueSpringBootTodoList" target="_blank">
      <GitHubLogoSVG />
    </a>
  </div>
</template>

<script>
import GitHubLogoSVG from '../components/svg/GitHubLogoSVG'
export default {
  name: 'About',
  components: { GitHubLogoSVG }
}
</script>

<style scoped>
.container {
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
}

.container h1 {
  margin: 1rem 0;
  font-size: 2rem;
}

.container p {
  font-size: 1.5rem;
  margin-bottom: 1.5rem;
}

.container ul li {
  padding-bottom: 0.5rem;
  margin-bottom: 0.5rem;
  list-style: none;
  text-align: center;
}

.container ul li:not(:last-of-type) {
  border-bottom: 1px solid rgba(44, 62, 80, 50%);
}

.container ul li a {
  text-decoration: none;
  color: #2c3e50;
  cursor: pointer;
}
</style>
