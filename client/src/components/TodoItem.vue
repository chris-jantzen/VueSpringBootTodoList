<template>
  <div class="todo-item">
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
    SaveSVG
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
      this.todo.title = this.todoTitleCopy
      this.todoTitleCopy = ''
      await updateTitle(this.todo.id, this.todo.title)
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
  align-items: center;
  overflow-x: hidden;
}
#item-text {
  cursor: pointer;
  display: flex;
  align-items: center;
}
#editInputBox {
  height: 35px;
  width: 35vw;
  font-size: 1.25rem;
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
#delete,
#edit,
#cancel,
#save {
  cursor: pointer;
  margin-right: 0.75rem;
}
#edit:hover path {
  fill: #3b94b9;
}
#delete:hover path {
  fill: #aa0000;
}
#cancel {
  fill: red;
  margin-right: 0.5rem;
}
#cancel:hover {
  fill: #b40000;
}
#save {
  fill: #2bd900;
  margin-right: 0.5rem;
}
#save:hover {
  fill: #1e9400 !important;
}
.primaryIcons,
.onEditIcons {
  display: flex;
  justify-content: space-between;
  align-items: center;
}
</style>
