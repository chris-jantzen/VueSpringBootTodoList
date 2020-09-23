<template>
  <div class="todo-item">
    <p
      id="item-text"
      @click="markComplete"
      v-bind:class="{ 'is-complete': todo.completed }"
    >
      {{ todo.title }}
    </p>
    <button @click="$emit('del-todo', todo.id)" class="del">x</button>
  </div>
</template>

<script>
import { updateTodo } from '../services/todoService'
export default {
  name: 'TodoItem',
  props: ['todo'],
  methods: {
    async markComplete() {
      this.todo.completed = !this.todo.completed
      await updateTodo(this.todo.id, this.todo.completed)
    },
  },
}
</script>

<style scoped>
.todo-item {
  background: #f4f4f4;
  padding: 10px;
  border-bottom: 1px #ccc dotted;
  display: flex;
  justify-content: space-between;
}
#item-text {
  cursor: pointer;
  display: flex;
  align-items: center;
}
.is-complete {
  text-decoration: line-through;
}
.del {
  background: #ff0000;
  color: #fff;
  border: none;
  padding: 5px 9px;
  border-radius: 50%;
  cursor: pointer;
  /* float: right; */
}
</style>
