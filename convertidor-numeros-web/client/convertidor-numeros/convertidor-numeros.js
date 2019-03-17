import { Template } from 'meteor/templating';
import { ReactiveVar } from 'meteor/reactive-var';
import { HTTP } from 'meteor/http'

Template.converter.onCreated(function converterOnCreated() {
  this.numberPressed = new ReactiveVar(null);
});

Template.converter.helpers({
  numberPressed() {
    return Template.instance().numberPressed.get();
  },
});

Template.converter.events({
  'keyup #input-arabigo': function(event, instance) {
      let arabigNumber = $(event.currentTarget).val();
      if (arabigNumber) {
        HTTP.get('http://localhost:8080/convertir/arabigo/romano/' + arabigNumber, {}, (error, result) => {
         if (!error) {
            instance.numberPressed.set(result.content);
         } else {
           instance.numberPressed.set(error.response.content);
         }
        });
      } else {
        instance.numberPressed.set(null);
      }
  },
});
