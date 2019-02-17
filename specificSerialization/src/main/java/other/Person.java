package other;

public final class Person {
    private final int id;
    private final int phone;
    private final int additionalPhone;
    private final int officeNumber;
    private final int luckyNumber;

    private Person(Builder builder) {
        id = builder.id;
        phone = builder.phone;
        additionalPhone = builder.additionalPhone;
        officeNumber = builder.officeNumber;
        luckyNumber = builder.luckyNumber;
    }

    public static class Builder {
        private int id;
        private int phone;
        private int additionalPhone;
        private int officeNumber;
        private int luckyNumber;

        public Builder setId(int i) {
            id = i;
            return this;
        }

        public Builder setPhone(int i) {
            phone = i;
            return this;
        }

        public Builder setAdditionalPhone(int i) {
            additionalPhone = i;
            return this;
        }

        public Builder setOfficeNumber(int i) {
            officeNumber = i;
            return this;
        }

        public Builder setLuckyNumber(int i) {
            luckyNumber = i;
            return this;
        }

        public Person build() {
            return new Person(this);
        }
    }

    public int getId() {
        return id;
    }

    public int getPhone() {
        return phone;
    }

    public int getAdditionalPhone() {
        return additionalPhone;
    }

    public int getLuckyNumber() {
        return luckyNumber;
    }

    public int getOfficeNumber() {
        return officeNumber;
    }
}
