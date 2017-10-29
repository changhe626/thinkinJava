package com.myEnum;

public enum OzWitch {
    /**
     * 枚举的定义要放在最前面,放在后面会报错
     */
    WEST("west"),NORTH("north"),EAST("east"),SOURTH("sourth");
    private String description;

    private OzWitch(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public static void main(String[] args) {
        OzWitch[] values = OzWitch.values();
        for (OzWitch value : values) {
            System.out.println(value);
            System.out.println(value.getDescription());
        }
    }




}
