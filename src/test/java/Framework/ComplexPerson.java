package Framework;

public final class ComplexPerson {
    private String name;
    private String language;
    private String location;

    public Personal getPersonal() {
        return personal;
    }

    private Personal personal;

    public void setPersonal(Personal personal) {
        this.personal = personal;
    }

    public String getName() {
        return name;
    }

    public String getLanguage() {
        return language;
    }

    public String getLocation() {
        return location;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public final class Personal {
        private Integer age;
        private String hobby;

        public void setAge(Integer age) {
            this.age = age;
        }

        public void setHobby(String hobby) {
            this.hobby = hobby;
        }

        public Integer getAge() {
            return age;
        }

        public String getHobby() {
            return hobby;
        }
    }
}