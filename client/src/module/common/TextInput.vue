<template>
  <div>
    <label :html-for="inputName">{{ inputName }}</label>
    <input
      :id="inputName"
      type="text"
      class="btn"
      :style="styles"
      :placeholder="placeholder"
      @input="$emit('handle-change', $event)"
      v-model="value"
    />
  </div>
</template>

<style scoped>
@import url('../../assets/css/init.css');
@import url('../../assets/css/root.css');
@import url('../../assets/css/typography.css');

Input[type='text'] {
  padding: 0.5rem 0.75rem 0.5rem 0.75rem;
  width: var(--width);
  border: 1px solid var(--light-color-black);
  border-radius: 6px;
  outline: none;
}

Input::placeholder {
  color: var(--light-color-grey);
}
</style>

<script>
export default {
  name: 'TextInput',
  props: {
    placeholder: String,
    inputName: String,
    callback: Function,
    width: String,
  },
  methods: {
    handleChange(event) {
      const data = this.value;
      this.$emit('handle-change', data);
    },
  },
  data() {
    return {
      value: '',
    };
  },
  computed: {
    styles() {
      return {
        '--width': this.width,
      };
    },
  },
};
</script>
