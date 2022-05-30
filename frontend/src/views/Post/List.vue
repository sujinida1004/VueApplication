<template>
  <v-container fluid>
    <h1>{{ title }}</h1>

    <v-data-table
      :headers="headers"
      :items="items"
      :items-per-page="5"
      class="elevation-1"
      @click:row="rowClicked"
    />

    <a
      href="/post/write"
      class="write_btn"
    >
      <img src="@/assets/images/pen_icon.png">
    </a>
  </v-container>
</template>

<script>
import apiBoard from "@/api/board";

export default {
  name: "BoardList",
  data() {
    return {
      title: "Post List",
      articles: null,
      headers: [
        { text: 'id', value: 'id', sortable: false },
        { text: 'title', value: 'title' },
        { text: 'body', value: 'body' },
        { text: 'userId', value: 'userId', align: 'start' },
      ],
      items: [],
    };
  },
  mounted() {
    apiBoard
      .getArticles(0)
      .then((response) => {
        if(response.status == 200) {
          console.log("getArticles", response);
          if(response.data != null){
            this.items = response.data;
          }
        }
      })
      .catch((e) => {
        console.log('error : ' + e);
        // throw new Error('Network response was not ok.');
      });
  },
  methods: {
    rowClicked(row) {
      console.log(row)
      this.$router.push({
        path: `/post/detail/${row.id}`,
      });
    },
  },
}
</script>

<style scoped>
.write_btn {
  position: fixed;
  bottom: 40px;
  right: 40px;
  width: 48px;
  height: 48px;
  border-radius: 50px;
  background: #fc1f49;
  box-shadow: 0px 10px 20px rgba(0, 0, 0, 0.05);
  z-index: 10;
  display: inline-block;
}
.write_btn img {
  position: relative;
  top: 50%;
  left: 50%;
  transform: translate(-50%, -55%);
}
</style>
