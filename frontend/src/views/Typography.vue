<template>
  <v-container>
    <v-card>
      <v-card-title>
        Typography
      </v-card-title>
      <v-card-text class="grey lighten-3">
        <v-card class="pa-3 text-h2 primary">
          컨텐츠 primary
        </v-card>
        <v-card class="pa-3 text-h2 primary--text">
          컨텐츠 primary--text
        </v-card>
        <v-card class="pa-3 text-h2 secondary">
          컨텐츠 secondary
        </v-card>
        <v-card class="pa-3 text-h2 secondary--text">
          컨텐츠 secondary--text
        </v-card>
        <v-card class="pa-3 text-h2 error">
          컨텐츠 error
        </v-card>
        <v-card class="pa-3 text-h2 error--text">
          컨텐츠 error--text
        </v-card>
        <v-card
          class="pa-3"
          outlined
        >
          <p class="text-h1">
            Heading 1
          </p>
          <p class="text-h2">
            Heading 2
          </p>
          <p class="text-h3 text-sm-subtitle-1">
            Heading 3
          </p>
          <!-- text-justify : 양 옆에 너비에 맞게 꽉참 (늘어남) -->
          <p class="text-justify">
            Morbi mattis ullamcorper velit. Donec orci lectus, aliquam ut, faucibus non, euismod id, nulla. Fusce convallis metus id felis luctus adipiscing. Aenean massa. Vestibulum purus quam, scelerisque ut, mollis sed, nonummy id, metus.

            Nulla consequat massa quis enim. Praesent venenatis metus at tortor pulvinar varius. Donec venenatis vulputate lorem. Phasellus accumsan cursus velit. Pellentesque ut neque.
          </p>
          <!-- text-sm-right : sm 이면 오른쪽 정렬 -->
          <p class="text-center text-sm-right">
            Center aligned text on all viewport sizes.
          </p>
        </v-card>
      </v-card-text>
    </v-card>
  </v-container>
</template>

<script>
export default {
  name: "TypographyPage"
}
</script>

<style scoped>

</style>
