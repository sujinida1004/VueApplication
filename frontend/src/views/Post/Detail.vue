<template>
  <v-card>
    <v-toolbar
      flat
      color="blue-grey"
      dark
    >
      <v-toolbar-title>Post Detail</v-toolbar-title>
    </v-toolbar>

    <v-card-text>
      <v-text-field
        v-model="post.id"
        filled
        label="Id"
      />

      <v-text-field
        v-model="post.title"
        filled
        label="Title"
      />

      <v-textarea
        v-model="post.body"
        filled
        label="Body"
      />

      <v-divider class="my-2" />

      <v-text-field
        v-model="post.userId"
        filled
        label="regId"
      />
    </v-card-text>

    <v-divider />
    <v-card-actions :to="{ path: '/post/list' }">
      <v-btn
        text
        @click="goBack"
      >
        Back
      </v-btn>
      <v-spacer />
      <v-btn
        color="success"
        depressed
      >
        수정
      </v-btn>
    </v-card-actions>
  </v-card>
</template>

<script>
import apiBoard from '@/api/board'

export default {
  name: "PostDetail",

  // data에 있는 속성값이 template에 바로 적용
  data() {
    return {
      post: [],
    }
  },

  // mounted 메소드 : 페이지 로딩되면 실행
  // board 속성의 파라메터로 넘어온 id를 지정
  // 경로 맨 뒤에 콜론id에 입력한 값이 로딩되었을때 board 속성에 적용
  mounted() {
    apiBoard
      .getArticle(this.$route.params.id)
      .then((response) => {
        console.log(response)
        this.post = response.data;
      })
      .catch((e) => {
        console.log(e);
      })
    this.post = this.$route.params.id;
  },

  methods: {
    goBack() {
      this.$router.go(-1);
    },
    editBoard() {
      this.$router.push({path: `/post/write/${this.$route.params.id}`})
    }
  },
}
</script>

<style scoped>

</style>
