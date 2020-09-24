import axios from 'axios'

const baseRoute = 'http://localhost:8080/api/v1/todo'

export const addTodo = async (todo) => {
  try {
    const { data } = await axios.post(baseRoute, { title: todo.title })
    return data
  } catch (err) {
    console.error(err)
  }
}

export const deleteTodo = async (id) => {
  try {
    return await axios.delete(`${baseRoute}/${id}`)
  } catch (err) {
    console.error(err)
  }
}

export const getTodos = async () => {
  try {
    const { data } = await axios.get(baseRoute)
    return data
  } catch (err) {
    console.error(err)
  }
}

export const markComplete = async (id, completed) => {
  try {
    return await axios.put(`${baseRoute}/${id}`, { completed })
  } catch (err) {
    console.error(err)
  }
}

export const updateTitle = async (id, title) => {
  try {
    return await axios.put(`${baseRoute}/${id}`, { title })
  } catch (err) {
    console.error(err)
  }
}
