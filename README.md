# egg-validator
use for validation email, mobile phone, Thai ID.
# Installation
# Usage
### Email Validation
**Normal**
```
boolean isEmail = EggValidator.isValidEmail("simple@gmail.com");
```

**Filter Company Domain** <br /><br />
filter the company domain is valid.
```
boolean email1 = EggValidator.isValidEmail("simple@gmail.com", EmailOption.GMAIL); // true
boolean email2 = EggValidator.isValidEmail("simple@gmail.com", "outlook.com"); // false
boolean email2 = EggValidator.isValidEmail("simple@gmail.com", "outlook.com","gmail.com"); // true
```
**Except Company Domain** <br /><br />
for except some company domain put 2nd param is true.
```
boolean email1 = EggValidator.isValidEmail("simple@gmail.com", true, EmailOption.GMAIL); // false
boolean email2 = EggValidator.isValidEmail("simple@gmail.com", true, "outlook.com"); // true
boolean email2 = EggValidator.isValidEmail("simple@gmail.com", true, "outlook.com","gmail.com"); // false
```

### Phone Validation
**Normal**
```
boolean phone1 = EggValidator.isValidPhone("0800560032"); // true
```
**Filter 2nd digit** <br />
this ex. 2nd digit of phone number must be 8 only.
```
boolean phone1 = EggValidator.isValidPhone("0800560032", 8); // true
boolean phone2 = EggValidator.isValidPhone("0600560032", 8); // false because 2nd digit is 6 not 8. 
```
**Except 2nd digit** <br />
this ex. 2nd digit of phone number do not be 8.
```
boolean phone1 = EggValidator.isValidPhone("0800560032", true, 8); // false
boolean phone2 = EggValidator.isValidPhone("0600560032", true, 8); // true 
```

### Thai ID validation
```
boolean thaiId = EggValidator.isValidThaiId("1234567890124");
```
