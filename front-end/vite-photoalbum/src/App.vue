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
        store,
        formEmail:'',
        formTitle:'',
        formText:''
      }
    },
    methods: {
      getAllImages() {
        axios.get(BASE_URL + "/images")
          .then(result => {
            console.log(result.data);

            store.images = result.data;
          })
      },
      sendContactForm() {
        const data = {
          email: this.formEmail,
          title: this.formTitle,
          text: this.formTitle
        }
        console.log(data);
        axios.post(`${BASE_URL}/contact`, data)
          .then(result => {
            console.log(result.data);
          })
      },
      generateImageLink(imageFileId) {
        return `http://localhost:8080/files/` + imageFileId;
      }
    },
    mounted() {
      this.getAllImages();
      
    }

  }
</script>

<template>
  <div class="container">
    <h1 class="my-3">Images</h1>

    <div class="row">

      <div
        class="col-4"
        v-for="image in store.images"
        :key="image.id"
        v-show="image.isVisible"
      >
        <div class="card">
          <img v-if="image.imageFile != null" :src="generateImageLink(image.imageFile.id)" class="card-img-top" :alt="image.title">
          <div class="card-body">
            <h5 class="card-title">{{image.title}}</h5>
            <p class="card-text">{{ image.description }}</p>
          </div>
        </div>
      </div>

    </div>
    <h1 class="mt-5">Contacts</h1>
    <form @submit.prevent="sendContactForm()" class="row">
      <div class="col-6 mb-3">
        <label for="email" class="form-label">Email address</label>
        <input v-model.trim="formEmail" type="email" class="form-control" id="email" placeholder="name@example.com">
      </div>
      <div class="col-6 mb-3">
        <label for="title" class="form-label">Title</label>
        <input v-model.trim="formTitle" type="text" class="form-control" id="title" placeholder="Title...">
      </div>
      <div class="col-12 mb-3">
        <label for="text" class="form-label">Message</label>
        <textarea v-model.trim="formText" class="form-control" id="text" rows="3"></textarea>
      </div>
      <div class="col-12">
        <button type="submit" class="btn btn-primary">
          Send
        </button>
      </div>
      
    </form>
  </div>
</template>

<style lang="scss">
  @use './styles/general.scss';
</style>
