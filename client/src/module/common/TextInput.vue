<template>
  <div class="text_input_container" :style="styles">
    <div class="text_input_container_label">
      <label :html-for="inputName" />
    </div>
    <div class="text_input_container_input">
      <input
        :id="inputName"
        :type="inputType"
        :placeholder="placeholder"
        :value="value"
        @change="$emit('input', $event.target.value)"
      />
      <p class="caption">{{ caption }}</p>
    </div>
  </div>
</template>

<script>
export default {
  name: 'TextInput',
  props: {
    inputName: String,
    inputType: {
      type: String,
      default: 'text',
    },
    placeholder: String,
    caption: String,
    value: String,
    margin: String,
  },
  computed: {
    styles() {
      return {
        '--margin': this.margin,
        '--display': this.caption ? 'block' : 'none',
      };
    },
  },
};
</script>

<style scoped>
@import url('../../assets/css/init.css');
@import url('../../assets/css/root.css');
@import url('../../assets/css/typography.css');
.text_input_container {
  margin-bottom: var(--margin);
}
input[type='text'],
input[type='email'],
input[type='password'] {
  padding: 0.75rem;
  border: 1px solid var(--light-color-black);
  border-radius: 6px;
  outline: none;
  font-size: 0.9rem;
  width: calc(100% - 2rem);
}

input::placeholder {
  color: var(--light-color-grey);
}
.caption {
  color: var(--light-color-darkgrey);
  text-align: right;
  font-size: 0.85rem;
  padding: 0.5rem 0 0.5rem 0;
  display: var(--display);
}
</style>
