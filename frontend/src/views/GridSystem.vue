<template>
  <!-- v-container : 컨텐츠의 폭, 웹사이트의 컨텐츠를 중앙으로 위치시켜줌 -->
  <!-- fluid : 양쪽끝 채워줌 -->
  <v-container fluid>
    <!-- card 가상의 컨텐츠 -->
    <v-card class="pa-3">
      <v-row no-gutters>
        <v-col>
          <v-card
            class="pa-3"
            outlined
          >
            Col 1
          </v-card>
        </v-col>
        <v-col>
          <v-card
            class="pa-3"
            outlined
          >
            Col 2
          </v-card>
        </v-col>
        <v-col>
          <v-card
            class="pa-3"
            outlined
          >
            Col 3
          </v-card>
        </v-col>
      </v-row>
      <v-row >
        <v-col>
          <v-card
            class="pa-3"
            outlined
          >
            Col 1
          </v-card>
        </v-col>
        <v-col>
          <v-card
            class="pa-3"
            outlined
          >
            Col 2
          </v-card>
        </v-col>
        <v-col>
          <v-card
            class="pa-3"
            outlined
          >
            Col 3
          </v-card>
        </v-col>
      </v-row>
    </v-card>

    <!-- align 속성 : 부모-자식간 수직정렬 -->
    <v-card class="mt-5 pa-3">
      <v-row
        :style="{ height: '120px' }"
        class="red"
        align="start"
      >
        <v-col>
          <v-card
            class="pa-3"
            outlined
          >
            Col 1
          </v-card>
        </v-col>
        <v-col>
          <v-card
            class="pa-3"
            outlined
          >
            Col 2
          </v-card>
        </v-col>
        <v-col>
          <v-card
            class="pa-3"
            outlined
          >
            Col 3
          </v-card>
        </v-col>
      </v-row>
      <v-row
        :style="{ height: '120px' }"
        class="yellow"
      >
        <v-col align-self="end">
          <!-- align-self 자기 자신만 정렬 -->
          <v-card
            class="pa-3"
            outlined
          >
            Col 1
          </v-card>
        </v-col>
        <v-col align-self="center">
          <v-card
            class="pa-3"
            outlined
          >
            Col 2
          </v-card>
        </v-col>
        <v-col>
          <v-card
            class="pa-3"
            outlined
          >
            Col 3
          </v-card>
        </v-col>
      </v-row>
    </v-card>
  </v-container>
</template>

<script>
export default {
  name: "GridSystem"
}
</script>

<style scoped>

</style>
