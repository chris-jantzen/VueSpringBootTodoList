<template>
  <div class="todo-item" v-bind:class="{ 'todo-padding': !activeEdit }">
    <div class="title">
      <p
        id="item-text"
        v-if="!activeEdit"
        @click="markComplete"
        v-bind:class="{ 'is-complete': todo.completed }"
      >
        {{ todo.title }}
      </p>
      <input
        v-model="todoTitleCopy"
        v-if="activeEdit"
        type="text"
        name="edit"
        id="editInputBox"
        :placeholder="todo.title"
      />
    </div>
    <div class="icons">
      <div class="primaryIcons" v-if="!activeEdit">
        <label @click="onEdit" for="editInputBox" id="edit">
          <EditSVG />
        </label>
        <DeleteSVG v-on:del-todo="$emit('del-todo', todo.id)" />
      </div>
      <div class="onEditIcons" v-if="activeEdit">
        <CancelSVG v-on:cancel-edit="onCancel" />
        <SaveSVG v-on:save-edit="onEditSubmit" />
      </div>
    </div>
  </div>
</template>

<script>
import { markComplete, updateTitle } from '../services/todoService'
import DeleteSVG from './svg/DeleteSVG.vue'
import EditSVG from './svg/EditSVG.vue'
import CancelSVG from './svg/CancelSVG.vue'
import SaveSVG from './svg/SaveSVG.vue'

export default {
  name: 'TodoItem',
  components: {
    DeleteSVG,
    EditSVG,
    CancelSVG,
    SaveSVG,
  },
  props: ['todo'],
  data() {
    return {
      activeEdit: false,
      todoTitleCopy: '',
    }
  },
  methods: {
    async markComplete() {
      this.todo.completed = !this.todo.completed
      await markComplete(this.todo.id, this.todo.completed)
    },
    onEdit() {
      this.activeEdit = true
    },
    onCancel() {
      this.activeEdit = false
    },
    async onEditSubmit() {
      this.activeEdit = false
      // Make sure a new title has been entered
      if (this.todoTitleCopy && this.todoTitleCopy !== this.todo.title) {
        this.todo.title = this.todoTitleCopy
        this.todoTitleCopy = ''
        await updateTitle(this.todo.id, this.todo.title)
      }
    },
  },
}
</script>

<style scoped>
.todo-item {
  background: #f4f4f4;
  padding: 7px 10px;
  border-bottom: 1px #ccc dotted;
  display: flex;
  justify-content: space-between;
  align-items: center;
  overflow-x: hidden;
}
.title {
  width: 100%;
}
.todo-padding {
  padding: 10px;
}
#item-text {
  cursor: pointer;
  display: flex;
  align-items: center;
}
#editInputBox {
  margin-left: -5px;
  padding: 5px;
  width: 60%;
  font-size: 1rem;
  border: 0;
  border-radius: 5px;
  padding-left: 5px;
}
.is-complete {
  text-decoration: line-through;
}
.icons {
  height: 100%;
  display: flex;
  justify-content: space-between;
  align-items: center;
}
.icons label {
  display: flex;
  align-items: center;
}
#edit {
  cursor: pointer;
  margin-right: 0.75rem;
}
.primaryIcons,
.onEditIcons {
  display: flex;
  justify-content: space-between;
  align-items: center;
}
</style>
