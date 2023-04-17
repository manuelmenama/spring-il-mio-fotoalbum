<script>
  import axios from 'axios';

  import { BASE_URL } from './data/data';
  import {store} from './data/store';

  export default {
    name: 'App',
    components: {},
    data(){
      return {
        BASE_URL,
        store
      }
    },
    methods: {
      getAllImages() {
        axios.get(BASE_URL + "/images")
          .then(result => {
            console.log(result.data);

            store.images = result.data;
          })
      }
    },
    mounted() {
      this.getAllImages();
    }

  }
</script>

<template>
  <div class="container">
    <div class="row">

      <div
        class="col-4"
        v-for="image in store.images"
        :key="image.id"

      >
        <div class="card">
          <img :src="image.pathImage" class="card-img-top" :alt="image.title">
          <div class="card-body">
            <h5 class="card-title">{{image.title}}</h5>
            <p class="card-text">{{ image.description }}</p>
          </div>
        </div>
      </div>

    </div>
    <h1 class="mt-5">Contacts</h1>
    <form action="" class="row">
      <div class="mb-3">
        <label for="email" class="form-label">Email address</label>
        <input type="email" class="form-control" id="email" placeholder="name@example.com">
      </div>
      <div class="mb-3">
        <label for="title" class="form-label">Title</label>
        <input type="email" class="form-control" id="title" placeholder="Title...">
      </div>
      <div class="mb-3">
        <label for="text" class="form-label">Message</label>
        <textarea class="form-control" id="text" rows="3"></textarea>
      </div>
    </form>
  </div>
</template>

<style lang="scss">
  @use './styles/general.scss';
</style>
