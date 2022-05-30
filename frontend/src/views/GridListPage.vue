<template>
  <v-container fluid>
    <v-row>
      <!-- 최대 12 cols를 가지고 있다. 12로 하면 꽉차고, 6으로 하면 반절만 나옴 -->
      <!-- material design breakpoint xs~xl까지 화면 사이즈에 따라 개수 다르게 지정가능! 기본은 xs -->
      <v-col
        v-for="count in 10"
        :key="count"
        cols="3"
        xs="5"
        sm="4"
        md="3"
        lg="2"
        xl="1"
      >
        <v-card outlined>
          최대 12 cols를 가지고 있다.
        </v-card>
      </v-col>
    </v-row>
    <v-row>
      <!-- cols=auto : 글자 사이즈에 맞게 크기가 조정됨 -->
      <v-col
        v-for="count in 10"
        :key="count"
        cols="auto"
      >
        <v-card outlined>
          cols="auto" 글자 사이즈에 맞게 크기가 조정됨
        </v-card>
      </v-col>
    </v-row>
    <v-row justify="space-around">
      <!-- justify="space-around" : 균등분할 중간정렬 -->
      <!-- justify="space-between" : 균등분할 첫째는 맨왼쪽, 마지막 맨 오른쪽 -->
      <!-- justify="start" : 맨 왼쪽 -->
      <!-- justify="center" : 중간 -->
      <!-- justify="end" : 맨 오른쪽 -->
      <v-col cols="auto">
        <v-card outlined>
          justify="space-around" : 균등분할
        </v-card>
      </v-col>
      <v-col cols="auto">
        <v-card outlined>
          justify="space-around" : 균등분할
        </v-card>
      </v-col>
      <v-col cols="auto">
        <v-card outlined>
          justify="space-around" : 균등분할
        </v-card>
      </v-col>
    </v-row>
    <v-row justify="space-between">
      <v-col cols="auto">
        <v-card outlined>
          justify="space-between" : 균등분할 맨왼쪽
        </v-card>
      </v-col>
      <v-col cols="auto">
        <v-card outlined>
          justify="space-between" : 균등분할 중간
        </v-card>
      </v-col>
      <v-col cols="auto">
        <v-card outlined>
          justify="space-between" : 균등분할 맨오른쪽
        </v-card>
      </v-col>
    </v-row>
  </v-container>
</template>

<script>
export default {
  name: "GridListPage"
}
</script>

<style scoped>

</style>
