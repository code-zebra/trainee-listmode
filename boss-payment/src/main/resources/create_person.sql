DROP TABLE IF EXISTS tax_note;

CREATE TABLE tax_note(
    -- 用户角色-缴款人/收款人
    role ENUM("payer", "payee"),
)
