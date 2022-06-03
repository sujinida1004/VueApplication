<!-- list.vue test branch -->
<template>
  <v-container>
    <v-form>
        <v-row>
          <v-col cols="12" sm="4" >
            <h1>{{ title }}</h1>
          </v-col>
        </v-row>

        <v-row>
          <v-col cols="12" sm="4" >
            <v-text-field v-model="searchkeyword" dense outlined label="이름 / 뒷번호4자리 / 전체 번호로 검색"
                          :style="{marginTop:10}" />
          </v-col>

          <v-col cols="12" sm="1" >
            <v-btn @click="searchStart" :style="{marginTop:10}">검색</v-btn>
          </v-col>
        </v-row>

        <v-row>
          <v-col cols="12" sm="12" >
            <v-data-table
              :headers="headers"
              :items="items"
              :items-per-page="viewCount"
              :page.sync="page"
              @page-count="pageCount = $event"
              class="elevation-1"
              hide-default-footer
              @click:row="rowClicked"
            />
          </v-col>
        </v-row>
    </v-form>

    <v-pagination v-model="page" :length="pageCount"></v-pagination>

    <a href="/board/write" class="write_btn">
      <img src="@/assets/images/pen_icon.png" alt="icon">
    </a>

  </v-container>
</template>

<script>
import apiBoard from "@/api/board";

export default {
  name: "BoardList",
  data() {
    return {
      title: "Board List",
      articles: null,
      headers: [
        { text: 'id', value: 'id', sortable: false },
        { text: 'title', value: 'title' },
        { text: 'contents', value: 'contents' },
        { text: 'reg_id', value: 'reg_id', align: 'start' },
        { text: 'reg_dt', value: 'reg_dt', align: 'center' },
      ],
      items: [],
      page: 1, // 선택 페이지
      pageCount: 5, // <v-pagination> 에 노출될 페이지 버튼 수
      viewCount: 2, // <v-data-table> 에 노출될 리스트 수
      searchkeyword: "",
    };
  },
  mounted() {
    apiBoard
      .getBoardList(0)
      .then((response) => {
        if(response.status.toString() == '200') {
          console.log("getBoardList", response);
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
        path: `/board/detail/${row.id}`,
      });
    },
    searchStart() {

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
