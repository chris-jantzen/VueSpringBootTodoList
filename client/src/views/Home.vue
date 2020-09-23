<template>
  <div id="app">
    <AddTodo v-on:add-todo="addTodo" />
    <Todos v-bind:todos="todos" v-on:del-todo="deleteTodo" />
  </div>
</template>

<script>
import Todos from '../components/Todos'
import AddTodo from '../components/AddTodo.vue'
import { addTodo, deleteTodo, getTodos } from '../services/todoService'

export default {
  name: 'Home',
  components: {
    Todos,
    AddTodo,
  },
  data() {
    return {
      todos: [],
    }
  },
  methods: {
    async deleteTodo(id) {
      await deleteTodo(id)
      this.todos = this.todos.filter((todo) => todo.id !== id)
    },
    async addTodo(newTodo) {
      const todo = await addTodo(newTodo)
      this.todos = [...this.todos, todo]
    },
  },
  async created() {
    try {
      this.todos = await getTodos()
    } catch (err) {
      console.error(err)
    }
  },
}
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  color: #2c3e50;
}

* {
  box-sizing: border-box;
  margin: 0;
  padding: 0;
}

.btn {
  display: inline-block;
  border: none;
  background: #555;
  color: #fff;
  padding: 7px 20px;
  cursor: pointer;
}

.btn:hover {
  background: #666;
}
</style>
