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
          <svg width="16" height="16" viewBox="0 0 24 24" fill="none">
            <path
              d="M14.76 4.44L19.56 9.24L4.8 24H0V19.2L14.76 4.44ZM16.44 2.76L19.2 0L24 4.8L21.24 7.56L16.44 2.76Z"
              fill="#4FCAFE"
            ></path>
          </svg>
        </label>
        <svg
          @click="onDelete"
          id="delete"
          width="16"
          height="16"
          viewBox="0 0 24 24"
          fill="none"
        >
          <path
            d="M0 3.9375V2.625C0 2.00156 0.573214 1.5 1.28571 1.5H7.28571L7.78929 0.623438C8.00357 0.239063 8.44821 0 8.93571 0H15.0589C15.5464 0 15.9911 0.239063 16.2107 0.623438L16.7143 1.5H22.7143C23.4268 1.5 24 2.00156 24 2.625V3.9375C24 4.24687 23.7107 4.5 23.3571 4.5H0.642857C0.289286 4.5 0 4.24687 0 3.9375ZM22.2429 6.59531L21.15 21.8906C21.0643 23.0766 19.9393 24 18.5839 24H5.41607C4.06071 24 2.93571 23.0766 2.85 21.8906L1.75714 6.59531C1.73571 6.27187 2.03036 6 2.4 6H21.6054C21.9696 6 22.2643 6.27187 22.2429 6.59531Z"
            fill="#D22D2D"
          ></path>
        </svg>
      </div>
      <div class="onEditIcons" v-if="activeEdit">
        <svg
          @click="onCancel"
          id="cancel"
          viewBox="-2 -2 24 24"
          width="16"
          height="16"
          preserveAspectRatio="xMinYMin"
        >
          <path
            d="M11.414 10l2.829-2.828a1 1 0 1 0-1.415-1.415L10 8.586 7.172 5.757a1 1 0 0 0-1.415 1.415L8.586 10l-2.829 2.828a1 1 0 0 0 1.415 1.415L10 11.414l2.828 2.829a1 1 0 0 0 1.415-1.415L11.414 10zM4 0h12a4 4 0 0 1 4 4v12a4 4 0 0 1-4 4H4a4 4 0 0 1-4-4V4a4 4 0 0 1 4-4z"
          ></path>
        </svg>
        <svg
          @click="onEditSubmit"
          id="save"
          width="24"
          height="24"
          viewBox="0 0 32 32"
        >
          <path
            d="M12 21.56L6.44001 16L4.55334 17.8867L12 25.3333L28 9.33334L26.1133 7.44667L12 21.56Z"
          ></path>
        </svg>
      </div>
    </div>
  </div>
</template>

<script>
import { markComplete, updateTitle } from '../services/todoService'
export default {
  name: 'TodoItem',
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
    onDelete() {
      this.$emit('del-todo', this.todo.id)
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
