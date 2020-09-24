<template>
  <div class="container">
    <h1>Todo List App</h1>
    <p>Implements</p>
    <ul>
      <li><a href="https://vuejs.org/" target="_blank">VueJS</a></li>
      <li><a href="https://spring.io/" target="_blank">Java Spring Boot</a></li>
      <li>
        <a href="https://www.postgresql.org/" target="_blank">PostgreSQL</a>
      </li>
    </ul>
    <a href="https://github.com/jantzeca/VueSpringBootTodoList" target="_blank">
      <svg
        version="1.1"
        xmlns="http://www.w3.org/2000/svg"
        width="60"
        height="60"
        viewBox="0 0 60 60"
      >
        <path
          d="M29.999 7.178c-12.922 0-23.399 10.477-23.399 23.401 0 10.339 6.703 19.109 16.003 22.202 1.171 0.217 1.597-0.504 1.597-1.126 0-0.554-0.020-2.025-0.031-3.98-6.509 1.415-7.883-3.137-7.883-3.137-1.064-2.703-2.599-3.422-2.599-3.422-2.125-1.451 0.161-1.423 0.161-1.423 2.348 0.166 3.584 2.411 3.584 2.411 2.087 3.576 5.477 2.541 6.81 1.946 0.212-1.515 0.818-2.544 1.486-3.13-5.195-0.59-10.658-2.598-10.658-11.564 0-2.555 0.911-4.645 2.408-6.281-0.239-0.589-1.044-2.968 0.23-6.191 0 0 1.964-0.629 6.436 2.401 1.865-0.521 3.868-0.782 5.858-0.79 1.987 0.008 3.99 0.268 5.858 0.79 4.468-3.029 6.43-2.401 6.43-2.401 1.277 3.223 0.473 5.602 0.233 6.191 1.5 1.636 2.405 3.725 2.405 6.281 0 8.987-5.47 10.967-10.683 11.545 0.839 0.723 1.588 2.154 1.588 4.337 0 3.127-0.028 5.65-0.028 6.417 0 0.627 0.421 1.356 1.609 1.124 9.289-3.099 15.988-11.863 15.988-22.199 0-12.924-10.477-23.401-23.401-23.401z"
        ></path>
      </svg>
    </a>
  </div>
</template>

<script>
export default {
  name: 'About',
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
