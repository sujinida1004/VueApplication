<template>
  <!-- v-app 반드시 최상단에 있어야 하는 루트 컴포넌트. id가 app인 div 로 치환 -->
  <!-- app 이라는 특수 속성을 붙여서 기본 레이아웃 컴포넌트로 사용가능. app 필수! -->
  <v-app>
    <!-- v-if="$vuetify.breakpoint.xsOnly" : 모바일 사이즈일때만 보이게 -->
    <v-app-bar
      v-if="$vuetify.breakpoint.xsOnly"
      app
    />
    <v-navigation-drawer app />

    <!-- 컨텐츠 영역. main 태그로 치환됨 -->
    <!-- vue가 dom에 마운트 될때, v-app-bar, v-navigation-drawer 이것을 프레임워크 코어단에 등록해줌. 컨텐츠 영역을 조절함! -->
    <v-main>
      <v-container fluid>
        컨텐츠 영역
      </v-container>
    </v-main>
    <v-footer app />
  </v-app>
</template>

<script>

export default {
  name: 'App',

  data: () => ({
    drawer: false,
    items: [
      { title: 'Dashboard', icon: 'mdi-view-dashboard', to: '/' }, // to : 메뉴를 클릭할때 이동
      { title: 'Grid System', icon: 'mdi-view-dashboard', to: '/grid-system' },
      { title: 'Grid List', icon: 'mdi-image', to: '/grid-list-page' },
      { title: 'Board List', icon: 'mdi-help-box', to: '/board-list' },
    ],
    right: null,
  }),
};
</script>
