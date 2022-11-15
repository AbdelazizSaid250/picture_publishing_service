package com.example.util;

public class Utils {

    private Utils() {
    }

    public enum PictureState {
        ACCEPTED,
        REJECTED,
        UNPROCESSED,
        ;

        @Override
        public String toString() {
            switch (this) {
                case ACCEPTED:
                    return "accepted";
                case REJECTED:
                    return "rejected";
                case UNPROCESSED:
                    return "unprocessed";
                default:
                    return "";
            }
        }
    }


    public enum PictureCategory {
        LIVING,
        MACHINE,
        NATURE,
        ;


        @Override
        public String toString() {
            switch (this) {
                case LIVING:
                    return "living thing";
                case MACHINE:
                    return "machine";
                case NATURE:
                    return "nature";
                default:
                    return "";
            }
        }


    }
}
