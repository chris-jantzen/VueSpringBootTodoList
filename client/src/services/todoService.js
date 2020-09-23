import axios from 'axios'

export const addTodo = async (todo) => {
  try {
    const { data } = await axios.post(
      'http://jsonplaceholder.typicode.com/todos',
      todo
    )
    return data
  } catch (err) {
    console.error(err)
  }
}

export const deleteTodo = async (id) => {
  try {
    return await axios.delete(`http://jsonplaceholder.typicode.com/todos/${id}`)
  } catch (err) {
    console.error(err)
  }
}

export const getTodos = async (limit) => {
  try {
    const { data } = await axios.get(
      `http://jsonplaceholder.typicode.com/todos?_limit=${limit}`
    )
    return data
  } catch (err) {
    console.error(err)
  }
}

export const updateTodo = async (id) => {
  try {
    return await axios.put(`http://jsonplaceholder.typicode.com/todos/${id}`)
  } catch (err) {
    console.error(err)
  }
}
