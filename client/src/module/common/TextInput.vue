<template>
  <div class="text_input_container" :style="styles">
    <div class="text_input_container_label">
      <label :html-for="inputName" />
    </div>
    <div
      v-if="inputType === 'textarea'"
      class="text_input_container_textarea"
    >
      <textarea
        :id="inputName"
        :value="value"
        :placeholder="placeholder"
        @input="$emit('input', $event.target.value)"
      >
      </textarea>
    </div>
    <div v-else class="text_input_container_input">
      <input
        :id="inputName"
        :type="inputType"
        :placeholder="placeholder"
        :value="value"
        @input="$emit('input', $event.target.value)"
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
    isValid() {
      const regex =
        /^(?=.*[a-z])(?=.*\d)(?=.*[@$!%*#?&])[a-z\d@$!%*#?&]{8,}$/i;
      return regex.test(this.value);
    },
    styles() {
      return {
        '--margin': this.margin,
        '--display': this.caption ? 'block' : 'none',
        '--caption-color':
          //중첩 삼항연산자입니다. inputType이 password이고 비밀번호가 valid하다면...
          this.inputType === 'password'
            ? this.isValid
              ? '#09DF78'
              : '#DF093D'
            : '#666666',
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
  width: 100%;
}
textarea {
  padding: 0.75rem;
  border: 1px solid var(--light-color-black);
  border-radius: 6px;
  outline: none;
  font-size: 0.9rem;
  width: 100%;
  height: 15rem;
  resize: none;
  line-height: 1.65;
  font-family: 'nm';
}
input::placeholder,
textarea::placeholder {
  color: var(--light-color-grey);
}
.caption {
  color: var(--caption-color);
  text-align: right;
  font-size: 0.85rem;
  padding: 0.5rem 0 0.5rem 0;
  display: var(--display);
}
</style>
