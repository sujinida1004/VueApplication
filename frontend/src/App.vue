<template>
  <!-- vuetify 설치시 v-app으로 변경됨 -->
  <v-app>
    <v-app-bar
      app
      color="primary"
      dark
    >
      <v-app-bar-nav-icon @click="drawer = !drawer" />

      <v-spacer />
    </v-app-bar>

    <!-- 기본그리드 형태인 app 속성을 넣는다 -->
    <v-navigation-drawer
      v-model="drawer"
      app
    >
      <v-list-item>
        <v-list-item-content>
          <v-list-item-title class="text-h6">
            Board Application
          </v-list-item-title>
          <v-list-item-subtitle>
            by sudin
          </v-list-item-subtitle>
        </v-list-item-content>
      </v-list-item>

      <v-divider />

      <v-list
        dense
        nav
      >
        <!-- to : 메뉴를 클릭할때 이동 -->
        <v-list-item
          v-for="item in items"
          :key="item.title"
          link
          :to="item.to"
        >
          <v-list-item-icon>
            <v-icon>{{ item.icon }}</v-icon>
          </v-list-item-icon>

          <v-list-item-content>
            <v-list-item-title>{{ item.title }}</v-list-item-title>
          </v-list-item-content>
        </v-list-item>
      </v-list>
    </v-navigation-drawer>
    <v-main>
      <v-container fluid>
        <router-view />
      </v-container>
    </v-main>
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
      { title: 'BreakPoints', icon: 'mdi-view-dashboard', to: '/BreakPoints' },
      { title: 'Typography', icon: 'mdi-view-dashboard', to: '/Typography' },
      { title: 'Post List', icon: 'mdi-help-box', to: '/post/list' },
      { title: 'Board List', icon: 'mdi-help-box', to: '/board/list' },
    ],
    right: null,
  }),
};
</script>
