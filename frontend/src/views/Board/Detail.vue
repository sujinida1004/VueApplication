<template>
  <v-card ref="form">
    <v-toolbar
      flat
      color="blue-grey"
      dark
    >
      <v-toolbar-title>Board Detail</v-toolbar-title>
    </v-toolbar>

    <v-card-text>
      <v-text-field
        ref="id"
        v-model="board.id"
        filled
        label="ID"
        :rules="[() => !!board.id || 'This field is required']"
        :error-messages="errorMessages"
        required
      />
      <v-text-field
        ref="title"
        v-model="board.title"
        filled
        label="Title"
        :rules="[() => !!board.title || 'This field is required']"
        :error-messages="errorMessages"
        required
      />
      <v-textarea
        ref="contents"
        v-model="board.contents"
        filled
        label="Contents"
        :rules="[() => !!board.contents || 'This field is required']"
        :error-messages="errorMessages"
        required
      />

      <v-divider class="my-2" />

      <v-text-field
        v-model="board.reg_id"
        filled
        label="regId"
      />
      <v-text-field
        v-model="board.reg_dt"
        filled
        label="regDt"
        value="2022.05.29"
      />
    </v-card-text>

    <v-divider />
    <v-card-actions :to="{ path: '/board/list' }">
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
        @click="submit"
      >
        수정
      </v-btn>
    </v-card-actions>
  </v-card>
</template>

<script>
import apiBoard from '@/api/board'

export default {
  name: "BoardDetail",
  // data에 있는 속성값이 template에 바로 적용
  data() {
    return {
      board: [],
      formHasErrors: false,
      errorMessages: '',
      id: null,
      title: null,
      contents: null,
    }
  },

  computed: {
    form () {
      return {
        id: this.board.id,
        title: this.board.title,
        contents: this.board.contents,
      }
    },
  },

  // mounted 메소드 : 페이지 로딩되면 실행
  // article 속성의 파라메터로 넘어온 id를 지정
  // 경로 맨 뒤에 콜론id에 입력한 값이 로딩되었을때 article 속성에 적용
  mounted() {
    apiBoard
      .getBoard(this.$route.params.id)
      .then((response) => {
        console.log(response)
        this.board = response.data;
      })
      .catch((e) => {
        console.log(e);
      })
    this.board = this.$route.params.id;
  },
  methods: {
    goBack() {
      this.$router.go(-1);
    },
    editArticle() {
      this.$router.push({path: `/board/write/${this.$route.params.id}`})
    },
    submit () {
      this.formHasErrors = false

      Object.keys(this.form).forEach(f => {
        if (!this.form[f]) this.formHasErrors = true
        this.$refs[f].validate(true)
      })

      if(!this.formHasErrors){
        apiBoard
          .patchBoard(this.board.id, this.board.title, this.board.contents)
          .then((response) => {
            console.log(response)
            alert("수정성공!")
            this.$router.go(-1)
          })
          .catch((e) => {
            console.log(e);
          })
        this.board = this.$route.params.id;
      }

    },
  },
}
</script>

<style scoped>

</style>
