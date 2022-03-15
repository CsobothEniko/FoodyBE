
<template>
  <div>
    <h2>Home</h2>
    <p>{{ title }}</p>
    <ul>
      <li v-for="task in tasks" v-bind:key="task.id" :class="{completed:task.completed}">
        {{ task.name }} - {{ task.due }}
      </li>
    </ul>
  </div>
</template>

<script>
//import { defineComponent } from '@vue/composition-api'

export default {
  name: "home",
  components: {},
  data() {
    return {
      title: "Home",
      tasks: [
        {
          id: 1,
          name: "első",
          completed: false,
          due: "2022-03-05",
        },
        {
          id: 2,
          name: "második",
          completed: true,
          due: "2022-03-05",
        },
        {
          id: 3,
          name: "harmadik",
          completed: false,
          due: "2022-03-05",
        },
        {
          id: 4,
          name: "negyedik",
          completed: false,
          due: "2022-03-05",
        },
      ],
    };
  },
  computed: {},
  created() {},
  methods: {},
};
</script>

<style scoped>
.completed{
  text-decoration:line-through;
}
</style>
