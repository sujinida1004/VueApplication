<!-- write.vue master2 -->
<template>
  <v-card>
    <v-toolbar
      flat
      color="blue-grey"
      dark
    >
      <v-toolbar-title>Board Write</v-toolbar-title>
    </v-toolbar>
    <v-card ref="form">
      <v-card-text>
        <v-text-field
          ref="title"
          v-model="title"
          :rules="[() => !!title || 'This field is required']"
          :error-messages="errorMessages"
          label="Title"
          required
        />
        <v-text-field
          ref="contents"
          v-model="contents"
          :rules="[
            () => !!contents || 'This field is required',
            () => !!contents && contents.length <= 25 || 'Address must be less than 25 characters',
          ]"
          label="Contents"
          counter="25"
          required
        />
        <v-text-field
          ref="reg_id"
          v-model="reg_id"
          :rules="[() => !!reg_id || 'This field is required']"
          :error-messages="errorMessages"
          label="등록ID"
          required
        />
      </v-card-text>
      <v-divider class="mt-12" />
      <v-card-actions :to="{ path: '/board/list' }">
        <v-btn
          text
          @click="goBack"
        >
          Back
        </v-btn>
        <v-spacer />
        <v-slide-x-reverse-transition>
          <v-tooltip
            v-if="formHasErrors"
            left
          >
            <template #activator="{ on, attrs }">
              <v-btn
                class="my-0"
                v-bind="attrs"
                @click="resetForm"
                v-on="on"
              >
                <v-icon>mdi-refresh</v-icon>
              </v-btn>
            </template>
            <span>Refresh form</span>
          </v-tooltip>
        </v-slide-x-reverse-transition>
        <v-btn
          color="success"
          @click="submit"
        >
          등록
        </v-btn>
      </v-card-actions>
    </v-card>
  </v-card>
</template>

<script>
import apiBoard from "@/api/board";

export default {
  name: "BoardWrite",
  data: () => ({
    errorMessages: '',
    title: null,
    contents: null,
    reg_id: 'sudin',
    formHasErrors: false,
  }),

  computed: {
    form () {
      return {
        title: this.title,
        contents: this.contents,
        reg_id: this.reg_id,
      }
    },
  },

  watch: {
    name () {
      this.errorMessages = ''
    },
  },

  methods: {
    goBack(){
      this.$router.go(-1); [2]
    },
    resetForm () {
      this.errorMessages = []
      this.formHasErrors = false

      Object.keys(this.form).forEach(f => {
        this.$refs[f].reset()
      })
    },
    submit () {
      this.formHasErrors = false

      Object.keys(this.form).forEach(f => {
        if (!this.form[f]) this.formHasErrors = true

        this.$refs[f].validate(true)
      })

      if(!this.formHasErrors){
        apiBoard
          .postBoard(this.title, this.contents, this.reg_id)
          .then((response) => {
            console.log(response)
            alert("등록성공!")
          })
          .catch((e) => {
            console.log(e);
          })
        // this.article = this.$route.params.id;
      }

    },
  },

}
</script>

<style scoped>

</style>
