# Real-Time Event Ticketing System

![Java](https://img.shields.io/badge/java-000?style=for-the-badge&logo=openjdk&logoColor=f89820)
![JWT](https://img.shields.io/badge/-JWT-000?style=for-the-badge&logo=json-web-tokens)
![Spring](https://img.shields.io/badge/spring-000?style=for-the-badge&logo=spring&logoColor=green)
![HIBERNATE](https://img.shields.io/badge/Hibernate-000?style=for-the-badge&logo=hibernate&logoColor=white)
![POSTGRES](https://img.shields.io/badge/-postgresql-000?style=for-the-badge&logo=postgresql)

![GitHub](https://img.shields.io/github/forks/anuja-rahul/ticketingApp?style&logo=github)
&nbsp;
![GitHub](https://img.shields.io/github/license/anuja-rahul/ticketingApp?style&logo=github)
&nbsp;
![GitHub](https://img.shields.io/github/stars/anuja-rahul/ticketingApp?style&logo=github)
&nbsp;
![Contributors](https://img.shields.io/github/contributors/anuja-rahul/ticketingApp?style&logo=github)
&nbsp;
![Watchers](https://img.shields.io/github/watchers/anuja-rahul/ticketingApp?style&logo=github)
&nbsp;

```shell
  _____ _    _       _   _             _   ___ ___
 |_   _(_)__| |_____| |_(_)_ _  __ _  /_\ | _ \_ _|
   | | | / _| / / -_)  _| | ' \/ _` |/ _ \|  _/| |
   |_| |_\__|_\_\___|\__|_|_||_\__, /_/ \_\_| |___|  v1.0
                               |___/
   running on Spring Boot 3.3.4
```

[![layers](https://mermaid.ink/img/pako:eNpVUsGO2yAU_BXr7dVxsLGxzVa9NNtTq0q7PVW-vBgco8XGArzdNMq_F5Ooq554M8O8xwAX6I2QwOFkcRmTb8-P3ZwkX62Z_dMskk-73efk8PNHZMN6I74E1RqtpY38B7zJL9K-qV5G7V7fhGe5GKe8seeofcD7HPR4RLcZN7nX6NxBDomQA67aJ4PSmj8QQlIX5r1K_kApvde730r4kZfL-yOkMEk7oRIh1mXr1IEf5SQ74KEUaF876OZr2IerNy_nuQfu7SpTWBeBXh4UhtuY_iefxHZS4ANqF0htUMgAL-DPS7w_5Xzo2Jt5UKeNX60O9Oj94vh-v8nZSflxPWa9mfZOiRGtH99atmcFa7CgktUUK0pFf8zbZijKfBA1yQuE6zWFBeet6zvwhmSkKvKGVoxWtGyqFM7Ac5LlJWN5WbZ0o1nw_DEmpCBZW7O8aauKVbRmpA4GGdN8vz19_AEpWLOexn8Bw7xf0R7x9S-eDK5R?type=png)](https://mermaid.live/edit#pako:eNpVUsGO2yAU_BXr7dVxsLGxzVa9NNtTq0q7PVW-vBgco8XGArzdNMq_F5Ooq554M8O8xwAX6I2QwOFkcRmTb8-P3ZwkX62Z_dMskk-73efk8PNHZMN6I74E1RqtpY38B7zJL9K-qV5G7V7fhGe5GKe8seeofcD7HPR4RLcZN7nX6NxBDomQA67aJ4PSmj8QQlIX5r1K_kApvde730r4kZfL-yOkMEk7oRIh1mXr1IEf5SQ74KEUaF876OZr2IerNy_nuQfu7SpTWBeBXh4UhtuY_iefxHZS4ANqF0htUMgAL-DPS7w_5Xzo2Jt5UKeNX60O9Oj94vh-v8nZSflxPWa9mfZOiRGtH99atmcFa7CgktUUK0pFf8zbZijKfBA1yQuE6zWFBeet6zvwhmSkKvKGVoxWtGyqFM7Ac5LlJWN5WbZ0o1nw_DEmpCBZW7O8aauKVbRmpA4GGdN8vz19_AEpWLOexn8Bw7xf0R7x9S-eDK5R)

## *TicketingAPI Class Diagram*

[//]: # ([![]&#40;https://mermaid.ink/img/pako:eNrtHV2TGzXyr0yZl9nDSUGKUGGLgsp-BJYjJJU1UHUsDxNb653LeMY3M16yR-E_dD_h3vhlp2-ppZZGY3uXo4qXZEdqtVqtVqvVarV_ncybBZkcT-ZV0XVnZbFsi9VVvShbMu_Lps5OZlc1r8ueL1Zlnf16VWfZh-Ijr5p6Oc0u-7b0_z_KbEjx9UjWZWuK8JemXYhChiYrFwCiLlYEFJBVUVYCZd-IMopV_MGKP8jmRX3-r01R5a_e_pNSf5S9bZqKFLVodFN0N6d0rLRRWfeijDDwDoN3ycAIt-l2qPwNMO1s9grwjX6ns44BO9zTrAjw02OhRehYRuzE7YNy72WxXpMWMFAU5YpPq2I9a4ScKZYdCUCr_vuOtGd9Y0HwktkrF4cGOtIT4JL0hqybruyb9o6R9fnnF3VP2utiTr74QmC7LuvFyd05G06u5vTVmi2ootpyFFvJ-Pdl13cuqGYl7PaStLflnAT6nLek6InLhttGzfuS9LzY7Sw0SNnbxWpdAeZb5bnDDTUhhyRlvT5t6utyqWlQBTmbP7_vDZtV0lO0naQ0l1MNCgWwEsjzmqlBJlGvYYkAKzb9Dan7cl6wKXzdNrelgH6OVmCNXhZ1saRtYAsxkk3LP1x0sonNDLdx3zZVZS2OQL3Tq2TBNPuB1Ium1Z-nm65vVsQU2PM9dVmjGN6SJZVh2skb-ccbqk1IRzXCG9Ktm7oj57Tn_m4LiVCVW49bJHchR-IL8EviwZklK7VOwWsxPb2NKmFr2wor2V32LlQtf5i93ZQVJptyBCeiGlG6mJaOM1LiEvzcRmE0Wwlc7wMkmgU6ognnQGj8Qd4FhyqkKiQ0ojYf2MfxRs6u3jfvSA1K6OKFNhDTbWpPjU216ABwJSAuh5RJbyAY2XBsA1wfkDAApEWMdx-UF4Q1irwxbRj5Y-BDQilAx0qlZQj48qV2Pbg9eup7mn3zS280PbbzDGv42HCYDcRo8K2aVH0fwq65clJ05PuebuqKE7pAS8OiZFvy83pxSqjioZI6ZeLqyex1066KvieLWbkiJ3cvy3rTk87q6rQqbTvkkSnQ69iAlHXXF_VcLt6-eEcu6vWm7zQrZO-PstuiKheUBbLe0AeYRc2pxYu2WdEecmNHYa1BQ6Rrjt3oJ8UFjHR_6D-2ZW-MDadYc_wX9ilZQ2GEjXF-SydSFNqGIBuY5iIGDMnwqi1avDrNTPOPmin6J11tfVHNyvk70nemdFW8F2WnxbqYUyvDVM2ldfSGUOYRyvo3lPMWPt7sDaHM74iqktyYNd90TZ27I2dTKivwsdOZifYcJhkdYohOw2LZkWar_I6eVqdK5JQA6FajD_3-wdacYWUn2W25Dm1AQ1vW6FNu0jnWISzlXKs45Fvwfk1uq2nHQlccp-cpzXS1tB1jWdXT0-2rTb9FiLG8FFZR7s7qkPPCEYdE707cdk6a_R39Qnv6gPaYfTEVHs95aYDFgZUm2zjrDfX_eKz0uT3EsYApuaeDbQ9GQg8RLIVOIr1KLGk-0i0QQOYMUn8f2WsAh2WzgIDzCoTw_fxICgu2mFNcRTgzgJdG1bg0nDardUX64m1FXmz6TUt8_eJgeN2WDd0K73BrcLNeWAR5sIKm0CBtDxVSlfvchn6qIT4kEfeADPP4ILZ4lwWi1Duaclvo22ZeVGd0VMzcdT5d5SLxKOUCYCVvFs97rFKwV1eqVcwsnO-0bjI2SXfSbJY3EFiZPucD3v_R6icyjNgocHLRoQWGEJi9sCng1uewwnHmWfajrnFPgsaiUHNdLBZRsQmaEwLakuFHTIZn0sa0zFX36COcwJUyT9314nT3LT124n3KhbOg9qxZo2lj-IEu3G1wQhBzSFfk-BphNchyc29v7kf-D-rJuS8px00euy7EWlG5ozILszPI_x00WUSlPIjz9_9Op12c4TN9cZbjjlIPbHj6MCp3WCMxf-YeHMAtU7sOt0-lAvPUy5GDI9jUsUVF4RG6qILEvyFzesoJ6kFdrSeTmez4VBrYuDLkRr_ttjDy-DBLCJ3yIFVBxg2Y9erW92KRuyLvUM4OADOv55O7U1v89K7JOlqqcwze9Ku22awJO1SwIdLBI1urnq2tfQpBifUOI6LKN2dFOU44VQNN26OkhPfn-AkHswc6hH7fLpdWwbhpEroWXbUXZ9IICB8BPCPKPXMEEXsKYpe-IrOkFTHCOVSVoPi64dPQoIEHj2oR_Zg68rhYYWdKDyAPLftpdv6ezDf0zxSX3UGYfnD-HGwVHXxtpC_Le5HEh1qaWkDPyHWxqZATolehjYmbol5URChndhfmnHy-lEO5IVXVYNeNZ2TVYP3ZpcAxjcfiCPyB45cotgd6_n5OOMlfc_J1v265HOYHcpgvSX_TLJ63y82K7dpN_wO7FsvxYo1rmn3d9-uvSbEgbSc-Lvui33TMUJhmP5K3obgTYWJsv7RZrdHm-i-vHevivG2bFgtV-apq3hbVadN28GbLLddTTLfo7kVZiZu3U_1hofyaSrK0QVgD-Znrk4Aw2KDZpoA8b0-20Lddxhy6LCrSuYVMFLqHO6r6FGK0-ES7bIoabTa4O4uav25Fbl83dly2gO27Il1XLNXhkakduSSo3qpJW1Qcm2xDTwtbeGjaZkTXf5g11_CGF4Gfgk6OfIIxTAGwAXoHyEU4AJikmX1BFc2yqGjPzaadm1WmeB6qz825UuOi6goGFIgFo1AFqj0tB8MIlSZaNAKcSw21h3OuTyhMxewCrkekjlFlgpfTTLQ7vSlYwKnj6DZ9W1SaqEa1HfZtMWe-tNOqKFcmyEB8ShHsZiws5vz9umzJAnfCi1lkt9UsgMYaq716H6n-OKoCMPtM33rL7oQiVnIAMEZ6tmVH6lqnMVAmghxWD7d2BIhzRNPzYlPzGPetYNQ0m9FFMRPySag91f-d3GVduawvavqXNS3fNsslxfC8W1Pa1MyAQj05VbMU-5AwCBm3vmnK-nXDl5Yz3QKSIWJ6XJSpa4BZ0b3b_rBVvdnFItDhtKgqZlRQIB2Q4ptl2-ya_2UU01pikmEJGztMwQOIo9QD8TwH5vwf3X18N0F8_9HqHd2U_iT7jxNUZVgGinPDI1geuoW3PWvhiMKRTwl2vBo2kYoO9SBG7h5eaIRCXJ3oQ5wqFXaI1-oJAaGDsfER54YjDOlFvcaAQShiDFDFIDoww8GHantVAUbeNhwEwPZhBUwt8hfNpl4EsXkAKDY6emGwkZoa-mJHUl4gVqnn6bao6HDZ-GnpTz9bha-uDf-gYPC1qujiH7YCw_yeAgjEvgjXumUrY0pNCuYtv8S7l0c547QXpNklDzLI-Pnlp88kwB7fsW-GjXFnVAB8yp2vGWx0XIN-XHbVqVX6yR1DbYZuuWMNWmoEsL0UnvFgaR6wRKeB1yaKtZ3EYhmU0goV5Ue6HwvCnCXBU5RLvgDlwRKpsYdUrjZVwSM-HXeBX5OrIscZ1sniV2u5gLvcidv0dJKDKRTockPm77in-5w5jUg9J4Fw5MVCubfAMcoy0_SE2-HltuQJF5zwq7u7sEHBSeLWapwixROXEwDICWDBqHq7uXNHBo53FmUcmQgjQFFR41CynSljlz-hqbFdqUhVPvQIifEqIcghEBXhRb0HnkLZ51n3oDxmehMFKWHikgQgPiXDIpsojMnr6EDSZmSpL9p-szYqqDHqxa_KmQfP0S3sRPN8va7khCt_YOeLrWkb0yZyZ2AHFZ8X_vHoRHAH-I4tFHmIO6wr7ZmCnaV2A5rnPu9TyOCAIUQIHebqMGv5n5fv2B0C3cOadtYsitAp0r6oZBEK0gsu7ZDXdHRserpAa75cTdfb7MamONoqdPO51Tf8M5cETGKAkoPFuaez7Iui8BWS55eculZJyO1-oOm9bykctxj2WHd_ySn9RuwzWGwrT_g4DJcyZfw6_YauewKc07iAnHTRQEBr9IF7vhQsQY66nINBPFYRjN2JnH1klQWMcwMxGXBAt9tc9qDOopYPjAMZx5pk85HxtVnDnZGuP69v1VDlZ25vpYLCn372ts_ZjXzM5UiZW56Ho1GnEpjLknddzoJFebWc3JM78fmd8b8EQz35hAtweJmL4M13wHG6aVuq3kWtuEYchcbhIgyTtMv0XIBCJwLSlaLA2zeOoUsId2RNinlf3hLQxntmwuDKRWVD7eDFGP-yy3MFDgY7OuPHR-iPx5kmJqdwklhJaDakN8D_A04pR6EmS0Jg3FdVI-dSNXPmyZvNPybLTnC80SkNjCnAImQSoTvGLTceRGHIydAeWmwg2T2MqpBGiwp0SwNnisgedI4Dw_j5mTWw4QbCRhlFvl0-PIALw_84NcgUGB-iXYavJX_B-B7FOhCWDSTnQdMiDGsnhC3Q9nDLoQGitwSL-Udgo_CAubKxIew5RglKerL2LR1RJ3dDuk-DHfp1sSQ6ssbaDBnybQBFntgI6YrZ0VgTZGjxwz9ugdytyVAsWcBkkFZCaJ34yJ63bXHHMUq9tt3GDgyw26xwaB_RdO4bNzH-2UdhtDIw5ml2-HKhwKeo_MZNy78mVhw6WEjDem050PTU4tWWSir90wL3awq_HXAF0MVbdjegSLs_tYOPDsbqiJ0oyHvf-4wfmDTVqeeuKLibuacEj7nQxBK81M7Q8DD3e2jXeHIIMBjNTnZaU8zj2VwUa_hHPBEAu0yNv8eywg_4Ra4XnzCQ2DBq6oKshyYEgRFu3YvvkzRi9LuSaLAC4EDU4A2_jedrnx6zRWDTV21Rs1ab_oaH8Gx52h32ZwnvdU2GJjDxTiCEVaTFoFzkwuXgsNWJi_BqYTCEV-1FQHgQPOyBsQyp09zKHeHzIFVMBKsYDoRgUL6HA5a691kxd4d1tWXtRiBpkuM9kFksgeeM7l48zijqcbAagpaC2oS2jmdMltk8CGUGsTUG8gQskKYiMe3rPdvq3urSNEJOgE3GlAwoSPTdvdU6GL2V9DrV6NZYCpZ9GJjsvxnloYlqNzyAi_EMHpVMCTwkWdxlfx5Z7HbwJb_iC-RuHczfwTpxl9TgGYRrMAejPQRDGAZ5YkfDOGqBWZIyXhEjyTbrneJAJtYkMhIHlUSt0GWKSHm1nJJoWYKOUkzxjEU7rpzdHijvm2ZZDN_f2NzyHETeiVprD9AFOeRrWrrrsfsBOhEPY1QflO1INjs_lR3OvlCCOwyD7f4PJLkD7B7IeBecDSy7BX4gwvPlHSS7S9p1AfLI2wp7Dyfd8_akYK69SGq-SBY-b_JCKxMFyffJA7Mksk1SQhavJ-tKVlzu-3KIRgW5iVkwvL7RagF0O9MpA7EgcViDi3oMneLl7NDwQ08LY8LgKVxYt7-qsE30VG3hq4OUjJmeXhjKkJOmLQ57ov_TaQsuqzERuYA_3BEThIs6j6VxdLKu_LEJOsChzBsMPB0EquFRwWdI3-RIOluMcTE0OdYAQaNxsDyxPIvv5fyGyhGaVTektMws42SGOZaanFDNhH_A8VC6P3rhNfUOT1TZw51I5QrRneAafrtFk6DwOwG5uvJ4vhR5Dw9AhFbHCHec0KE9OJqtZHi3AFG9HjhGF_JeL7xp2SG5Q_JqS9aoTmQ6CEsBwrC_UcgSJSlkNSRmg4jZD17A8w7BiJFO2DHXpztB0uzjegwmHp2KxFM_iJCM5uoua-igkniPIpYu5IdWCfciq9hOHN5-c-1DUDuYB2K25SPjcUB--cnCpH_6yaHt3n1-ohvfwB_0-wkwF68zXPCmwhquDti3Zo_HPusZ60IU-XrEVx7onfoDEvwjeQsdKLogtxOc0kZMzigdXc4-xDtYRrTeva9q_YNt2aNHX2T6mkNWSNnNHj-mdeIH8Y6z3_8jhvH7f4NQDMUQoOoKgbPn4mry8dUk-xuj7mpSOL9GxqrcXyhDcFiUKcELQoWf6zqE6h_qAhS2kDjHsU6bhX7SKs69UCufO2qAmjXWiJOwdDYC9GdYBkdhp9jfZSBzJ6s3q3IzfQ8SEcylkkiRwGK8vrsM5BYoO1YB1Z-LR-VEEIsx-itUflOZngdvC39gyG2s6NmDc3pI9vj_aRK6sFIrv0ucguRFOEzC0II0PwUjZRf72RXYK_JzFjuI7xCWGO_sBeYqbudXAuCKDIwEhfWFPg4u7oTxFkGNPvd_GsBmF5wqBBmkwefQ7go-mK8cdmmyZ-_R_OIstTXKPJgh1OYfrEnFmyJ6gXHtzV1AyKbzJMNfwEmYbkMeCqOUkUoXOyr48ucIYuOLtIsuGz9H5x6KJhGZl9PXl6cI_8NrMy6Kfjs3E1Qqh8bJoZP5MXkZOO0O1-nQfhVK65ZMuZt_SewfgZRAV7WTwsPthtEiKZA94dTVSN4MaHY6CS5YlZv0wmBBrHvUkIJ8x1pDC5oiuUywf8NkhDfPwc7TVvNw16EdKbWltxklU56-D4VpccUzdQxpsuLtLjaxdkBSrKvQmWCohXdpNZLNu-5hiYhjxxQsLwVcvlY2Cb50rW_e_PAbj4tUsFplgXV4GyPgxsuIyir9PKmhLk36v3in4zaJKMmdk6-Js9wpCxEwYmpS7K8ogtvILRsqtR7qbpfd2W04nvPBbocFvdt1a7df3w9LFoQUmduSoHz97sEFHpXAZt4L-OTp8VqOm594x733wI1V-s_ehvCkyL73pBYqNsyVwJUaVmFjg5Nhv5HHOBFowZ9rh-B9tZDUTXCh9y4nINORMQ6gcliPvshMGRCccv68By5K9gqFffPnKBLC-FSMIew8hkgWdqfdOFGPdTqkTmJt46ZPrOWwrWAFp1uefkyu3HDr8bzZa-fCu4esMLae62eLhS0mC0cMyThuJJMzJDbJiHY1R9EQP8HdgJ2MtAECNuSwHdna32-jUQdwnvyksTujGj3lYXMxarSk49nPnEsY-qDYJFwhIoDypUQiXAjlvjM1wFaUlwgDQ1wzrJpMJ_TItCrKxeR4wu-I2a5KVuRqckz_rEr2a16Tq_o3Clhs-ubyrp5Pjvt2Q6Z0P9wsbybH10XV0S8RM3JWFsu2WCmQdVH_o2lWGogsGIEvmwWh3bG0kxMOMzn-dfJ-cvzk6cePnzz7-Nmnn3307NNnz54-ezqd3E2OP3n6-LMnTz5-8sknTz_69Mlnz578Np38m2P96PHT3_4HfqnM8Q?type=png&#41;]&#40;https://mermaid.live/edit#pako:eNrtHV2TGzXyr0yZl9nDSUGKUGGLgsp-BJYjJJU1UHUsDxNb653LeMY3M16yR-E_dD_h3vhlp2-ppZZGY3uXo4qXZEdqtVqtVqvVarV_ncybBZkcT-ZV0XVnZbFsi9VVvShbMu_Lps5OZlc1r8ueL1Zlnf16VWfZh-Ijr5p6Oc0u-7b0_z_KbEjx9UjWZWuK8JemXYhChiYrFwCiLlYEFJBVUVYCZd-IMopV_MGKP8jmRX3-r01R5a_e_pNSf5S9bZqKFLVodFN0N6d0rLRRWfeijDDwDoN3ycAIt-l2qPwNMO1s9grwjX6ns44BO9zTrAjw02OhRehYRuzE7YNy72WxXpMWMFAU5YpPq2I9a4ScKZYdCUCr_vuOtGd9Y0HwktkrF4cGOtIT4JL0hqybruyb9o6R9fnnF3VP2utiTr74QmC7LuvFyd05G06u5vTVmi2ootpyFFvJ-Pdl13cuqGYl7PaStLflnAT6nLek6InLhttGzfuS9LzY7Sw0SNnbxWpdAeZb5bnDDTUhhyRlvT5t6utyqWlQBTmbP7_vDZtV0lO0naQ0l1MNCgWwEsjzmqlBJlGvYYkAKzb9Dan7cl6wKXzdNrelgH6OVmCNXhZ1saRtYAsxkk3LP1x0sonNDLdx3zZVZS2OQL3Tq2TBNPuB1Ium1Z-nm65vVsQU2PM9dVmjGN6SJZVh2skb-ccbqk1IRzXCG9Ktm7oj57Tn_m4LiVCVW49bJHchR-IL8EviwZklK7VOwWsxPb2NKmFr2wor2V32LlQtf5i93ZQVJptyBCeiGlG6mJaOM1LiEvzcRmE0Wwlc7wMkmgU6ognnQGj8Qd4FhyqkKiQ0ojYf2MfxRs6u3jfvSA1K6OKFNhDTbWpPjU216ABwJSAuh5RJbyAY2XBsA1wfkDAApEWMdx-UF4Q1irwxbRj5Y-BDQilAx0qlZQj48qV2Pbg9eup7mn3zS280PbbzDGv42HCYDcRo8K2aVH0fwq65clJ05PuebuqKE7pAS8OiZFvy83pxSqjioZI6ZeLqyex1066KvieLWbkiJ3cvy3rTk87q6rQqbTvkkSnQ69iAlHXXF_VcLt6-eEcu6vWm7zQrZO-PstuiKheUBbLe0AeYRc2pxYu2WdEecmNHYa1BQ6Rrjt3oJ8UFjHR_6D-2ZW-MDadYc_wX9ilZQ2GEjXF-SydSFNqGIBuY5iIGDMnwqi1avDrNTPOPmin6J11tfVHNyvk70nemdFW8F2WnxbqYUyvDVM2ldfSGUOYRyvo3lPMWPt7sDaHM74iqktyYNd90TZ27I2dTKivwsdOZifYcJhkdYohOw2LZkWar_I6eVqdK5JQA6FajD_3-wdacYWUn2W25Dm1AQ1vW6FNu0jnWISzlXKs45Fvwfk1uq2nHQlccp-cpzXS1tB1jWdXT0-2rTb9FiLG8FFZR7s7qkPPCEYdE707cdk6a_R39Qnv6gPaYfTEVHs95aYDFgZUm2zjrDfX_eKz0uT3EsYApuaeDbQ9GQg8RLIVOIr1KLGk-0i0QQOYMUn8f2WsAh2WzgIDzCoTw_fxICgu2mFNcRTgzgJdG1bg0nDardUX64m1FXmz6TUt8_eJgeN2WDd0K73BrcLNeWAR5sIKm0CBtDxVSlfvchn6qIT4kEfeADPP4ILZ4lwWi1Duaclvo22ZeVGd0VMzcdT5d5SLxKOUCYCVvFs97rFKwV1eqVcwsnO-0bjI2SXfSbJY3EFiZPucD3v_R6icyjNgocHLRoQWGEJi9sCng1uewwnHmWfajrnFPgsaiUHNdLBZRsQmaEwLakuFHTIZn0sa0zFX36COcwJUyT9314nT3LT124n3KhbOg9qxZo2lj-IEu3G1wQhBzSFfk-BphNchyc29v7kf-D-rJuS8px00euy7EWlG5ozILszPI_x00WUSlPIjz9_9Op12c4TN9cZbjjlIPbHj6MCp3WCMxf-YeHMAtU7sOt0-lAvPUy5GDI9jUsUVF4RG6qILEvyFzesoJ6kFdrSeTmez4VBrYuDLkRr_ttjDy-DBLCJ3yIFVBxg2Y9erW92KRuyLvUM4OADOv55O7U1v89K7JOlqqcwze9Ku22awJO1SwIdLBI1urnq2tfQpBifUOI6LKN2dFOU44VQNN26OkhPfn-AkHswc6hH7fLpdWwbhpEroWXbUXZ9IICB8BPCPKPXMEEXsKYpe-IrOkFTHCOVSVoPi64dPQoIEHj2oR_Zg68rhYYWdKDyAPLftpdv6ezDf0zxSX3UGYfnD-HGwVHXxtpC_Le5HEh1qaWkDPyHWxqZATolehjYmbol5URChndhfmnHy-lEO5IVXVYNeNZ2TVYP3ZpcAxjcfiCPyB45cotgd6_n5OOMlfc_J1v265HOYHcpgvSX_TLJ63y82K7dpN_wO7FsvxYo1rmn3d9-uvSbEgbSc-Lvui33TMUJhmP5K3obgTYWJsv7RZrdHm-i-vHevivG2bFgtV-apq3hbVadN28GbLLddTTLfo7kVZiZu3U_1hofyaSrK0QVgD-Znrk4Aw2KDZpoA8b0-20Lddxhy6LCrSuYVMFLqHO6r6FGK0-ES7bIoabTa4O4uav25Fbl83dly2gO27Il1XLNXhkakduSSo3qpJW1Qcm2xDTwtbeGjaZkTXf5g11_CGF4Gfgk6OfIIxTAGwAXoHyEU4AJikmX1BFc2yqGjPzaadm1WmeB6qz825UuOi6goGFIgFo1AFqj0tB8MIlSZaNAKcSw21h3OuTyhMxewCrkekjlFlgpfTTLQ7vSlYwKnj6DZ9W1SaqEa1HfZtMWe-tNOqKFcmyEB8ShHsZiws5vz9umzJAnfCi1lkt9UsgMYaq716H6n-OKoCMPtM33rL7oQiVnIAMEZ6tmVH6lqnMVAmghxWD7d2BIhzRNPzYlPzGPetYNQ0m9FFMRPySag91f-d3GVduawvavqXNS3fNsslxfC8W1Pa1MyAQj05VbMU-5AwCBm3vmnK-nXDl5Yz3QKSIWJ6XJSpa4BZ0b3b_rBVvdnFItDhtKgqZlRQIB2Q4ptl2-ya_2UU01pikmEJGztMwQOIo9QD8TwH5vwf3X18N0F8_9HqHd2U_iT7jxNUZVgGinPDI1geuoW3PWvhiMKRTwl2vBo2kYoO9SBG7h5eaIRCXJ3oQ5wqFXaI1-oJAaGDsfER54YjDOlFvcaAQShiDFDFIDoww8GHantVAUbeNhwEwPZhBUwt8hfNpl4EsXkAKDY6emGwkZoa-mJHUl4gVqnn6bao6HDZ-GnpTz9bha-uDf-gYPC1qujiH7YCw_yeAgjEvgjXumUrY0pNCuYtv8S7l0c547QXpNklDzLI-Pnlp88kwB7fsW-GjXFnVAB8yp2vGWx0XIN-XHbVqVX6yR1DbYZuuWMNWmoEsL0UnvFgaR6wRKeB1yaKtZ3EYhmU0goV5Ue6HwvCnCXBU5RLvgDlwRKpsYdUrjZVwSM-HXeBX5OrIscZ1sniV2u5gLvcidv0dJKDKRTockPm77in-5w5jUg9J4Fw5MVCubfAMcoy0_SE2-HltuQJF5zwq7u7sEHBSeLWapwixROXEwDICWDBqHq7uXNHBo53FmUcmQgjQFFR41CynSljlz-hqbFdqUhVPvQIifEqIcghEBXhRb0HnkLZ51n3oDxmehMFKWHikgQgPiXDIpsojMnr6EDSZmSpL9p-szYqqDHqxa_KmQfP0S3sRPN8va7khCt_YOeLrWkb0yZyZ2AHFZ8X_vHoRHAH-I4tFHmIO6wr7ZmCnaV2A5rnPu9TyOCAIUQIHebqMGv5n5fv2B0C3cOadtYsitAp0r6oZBEK0gsu7ZDXdHRserpAa75cTdfb7MamONoqdPO51Tf8M5cETGKAkoPFuaez7Iui8BWS55eculZJyO1-oOm9bykctxj2WHd_ySn9RuwzWGwrT_g4DJcyZfw6_YauewKc07iAnHTRQEBr9IF7vhQsQY66nINBPFYRjN2JnH1klQWMcwMxGXBAt9tc9qDOopYPjAMZx5pk85HxtVnDnZGuP69v1VDlZ25vpYLCn372ts_ZjXzM5UiZW56Ho1GnEpjLknddzoJFebWc3JM78fmd8b8EQz35hAtweJmL4M13wHG6aVuq3kWtuEYchcbhIgyTtMv0XIBCJwLSlaLA2zeOoUsId2RNinlf3hLQxntmwuDKRWVD7eDFGP-yy3MFDgY7OuPHR-iPx5kmJqdwklhJaDakN8D_A04pR6EmS0Jg3FdVI-dSNXPmyZvNPybLTnC80SkNjCnAImQSoTvGLTceRGHIydAeWmwg2T2MqpBGiwp0SwNnisgedI4Dw_j5mTWw4QbCRhlFvl0-PIALw_84NcgUGB-iXYavJX_B-B7FOhCWDSTnQdMiDGsnhC3Q9nDLoQGitwSL-Udgo_CAubKxIew5RglKerL2LR1RJ3dDuk-DHfp1sSQ6ssbaDBnybQBFntgI6YrZ0VgTZGjxwz9ugdytyVAsWcBkkFZCaJ34yJ63bXHHMUq9tt3GDgyw26xwaB_RdO4bNzH-2UdhtDIw5ml2-HKhwKeo_MZNy78mVhw6WEjDem050PTU4tWWSir90wL3awq_HXAF0MVbdjegSLs_tYOPDsbqiJ0oyHvf-4wfmDTVqeeuKLibuacEj7nQxBK81M7Q8DD3e2jXeHIIMBjNTnZaU8zj2VwUa_hHPBEAu0yNv8eywg_4Ra4XnzCQ2DBq6oKshyYEgRFu3YvvkzRi9LuSaLAC4EDU4A2_jedrnx6zRWDTV21Rs1ab_oaH8Gx52h32ZwnvdU2GJjDxTiCEVaTFoFzkwuXgsNWJi_BqYTCEV-1FQHgQPOyBsQyp09zKHeHzIFVMBKsYDoRgUL6HA5a691kxd4d1tWXtRiBpkuM9kFksgeeM7l48zijqcbAagpaC2oS2jmdMltk8CGUGsTUG8gQskKYiMe3rPdvq3urSNEJOgE3GlAwoSPTdvdU6GL2V9DrV6NZYCpZ9GJjsvxnloYlqNzyAi_EMHpVMCTwkWdxlfx5Z7HbwJb_iC-RuHczfwTpxl9TgGYRrMAejPQRDGAZ5YkfDOGqBWZIyXhEjyTbrneJAJtYkMhIHlUSt0GWKSHm1nJJoWYKOUkzxjEU7rpzdHijvm2ZZDN_f2NzyHETeiVprD9AFOeRrWrrrsfsBOhEPY1QflO1INjs_lR3OvlCCOwyD7f4PJLkD7B7IeBecDSy7BX4gwvPlHSS7S9p1AfLI2wp7Dyfd8_akYK69SGq-SBY-b_JCKxMFyffJA7Mksk1SQhavJ-tKVlzu-3KIRgW5iVkwvL7RagF0O9MpA7EgcViDi3oMneLl7NDwQ08LY8LgKVxYt7-qsE30VG3hq4OUjJmeXhjKkJOmLQ57ov_TaQsuqzERuYA_3BEThIs6j6VxdLKu_LEJOsChzBsMPB0EquFRwWdI3-RIOluMcTE0OdYAQaNxsDyxPIvv5fyGyhGaVTektMws42SGOZaanFDNhH_A8VC6P3rhNfUOT1TZw51I5QrRneAafrtFk6DwOwG5uvJ4vhR5Dw9AhFbHCHec0KE9OJqtZHi3AFG9HjhGF_JeL7xp2SG5Q_JqS9aoTmQ6CEsBwrC_UcgSJSlkNSRmg4jZD17A8w7BiJFO2DHXpztB0uzjegwmHp2KxFM_iJCM5uoua-igkniPIpYu5IdWCfciq9hOHN5-c-1DUDuYB2K25SPjcUB--cnCpH_6yaHt3n1-ohvfwB_0-wkwF68zXPCmwhquDti3Zo_HPusZ60IU-XrEVx7onfoDEvwjeQsdKLogtxOc0kZMzigdXc4-xDtYRrTeva9q_YNt2aNHX2T6mkNWSNnNHj-mdeIH8Y6z3_8jhvH7f4NQDMUQoOoKgbPn4mry8dUk-xuj7mpSOL9GxqrcXyhDcFiUKcELQoWf6zqE6h_qAhS2kDjHsU6bhX7SKs69UCufO2qAmjXWiJOwdDYC9GdYBkdhp9jfZSBzJ6s3q3IzfQ8SEcylkkiRwGK8vrsM5BYoO1YB1Z-LR-VEEIsx-itUflOZngdvC39gyG2s6NmDc3pI9vj_aRK6sFIrv0ucguRFOEzC0II0PwUjZRf72RXYK_JzFjuI7xCWGO_sBeYqbudXAuCKDIwEhfWFPg4u7oTxFkGNPvd_GsBmF5wqBBmkwefQ7go-mK8cdmmyZ-_R_OIstTXKPJgh1OYfrEnFmyJ6gXHtzV1AyKbzJMNfwEmYbkMeCqOUkUoXOyr48ucIYuOLtIsuGz9H5x6KJhGZl9PXl6cI_8NrMy6Kfjs3E1Qqh8bJoZP5MXkZOO0O1-nQfhVK65ZMuZt_SewfgZRAV7WTwsPthtEiKZA94dTVSN4MaHY6CS5YlZv0wmBBrHvUkIJ8x1pDC5oiuUywf8NkhDfPwc7TVvNw16EdKbWltxklU56-D4VpccUzdQxpsuLtLjaxdkBSrKvQmWCohXdpNZLNu-5hiYhjxxQsLwVcvlY2Cb50rW_e_PAbj4tUsFplgXV4GyPgxsuIyir9PKmhLk36v3in4zaJKMmdk6-Js9wpCxEwYmpS7K8ogtvILRsqtR7qbpfd2W04nvPBbocFvdt1a7df3w9LFoQUmduSoHz97sEFHpXAZt4L-OTp8VqOm594x733wI1V-s_ehvCkyL73pBYqNsyVwJUaVmFjg5Nhv5HHOBFowZ9rh-B9tZDUTXCh9y4nINORMQ6gcliPvshMGRCccv68By5K9gqFffPnKBLC-FSMIew8hkgWdqfdOFGPdTqkTmJt46ZPrOWwrWAFp1uefkyu3HDr8bzZa-fCu4esMLae62eLhS0mC0cMyThuJJMzJDbJiHY1R9EQP8HdgJ2MtAECNuSwHdna32-jUQdwnvyksTujGj3lYXMxarSk49nPnEsY-qDYJFwhIoDypUQiXAjlvjM1wFaUlwgDQ1wzrJpMJ_TItCrKxeR4wu-I2a5KVuRqckz_rEr2a16Tq_o3Clhs-ubyrp5Pjvt2Q6Z0P9wsbybH10XV0S8RM3JWFsu2WCmQdVH_o2lWGogsGIEvmwWh3bG0kxMOMzn-dfJ-cvzk6cePnzz7-Nmnn3307NNnz54-ezqd3E2OP3n6-LMnTz5-8sknTz_69Mlnz578Np38m2P96PHT3_4HfqnM8Q&#41;)
[//]: # (![ClassDiagram]&#40;ticketingappClassDiagramDark.svg&#41;)

```mermaid

classDiagram
direction BT
class Admin {
  + Admin(long, String, String, String) 
  + Admin() 
  - String password
  - long id
  - String name
  - String email
  + toString() String
  # canEqual(Object) boolean
  + hashCode() int
  + equals(Object) boolean
   String name
   String password
   long id
   String email
}
class AdminDTO {
  + AdminDTO(long, String, String, String) 
  + AdminDTO() 
  - String email
  - String password
  - String name
  - long id
  + hashCode() int
  + equals(Object) boolean
  + toString() String
  # canEqual(Object) boolean
   String name
   String password
   long id
   String email
}
class AdminMapper {
  + AdminMapper() 
  + mapToAdmin(AdminDTO) Admin
  + mapToUserDto(AdminDTO) UserDTO
  + mapToAdminDto(Admin) AdminDTO
}
class AdminRepository {
<<Interface>>
  + findByEmail(String) Optional~Admin~
  + existsByEmail(String) boolean
}
class AdminService {
<<Interface>>
  + createAdmin(AdminDTO) void
  + getAdminByEmail(String) AdminDTO
}
class AdminServiceImpl {
  + AdminServiceImpl(AdminRepository) 
  + createAdmin(AdminDTO) void
  + getAdminByEmail(String) AdminDTO
}
class AppConfig {
  + AppConfig(UserRepository) 
  + userDetailsService() UserDetailsService
  + passwordEncoder() PasswordEncoder
  + authenticationProvider() AuthenticationProvider
  + authenticationManager(AuthenticationConfiguration) AuthenticationManager
}
class AuthenticationController {
  + AuthenticationController(AuthenticationService, VendorService, CustomerService, AdminService, PasswordEncoder) 
  + register(RegisterRequest) ResponseEntity~AuthenticationResponse~
  + authenticate(AuthenticationRequest) ResponseEntity~AuthenticationResponse~
}
class AuthenticationRequest {
  + AuthenticationRequest() 
  + AuthenticationRequest(String, String) 
  ~ String password
  - String email
  + equals(Object) boolean
  # canEqual(Object) boolean
  + hashCode() int
  + toString() String
  + builder() AuthenticationRequestBuilder
   String email
   String password
}
class AuthenticationRequestBuilder {
  ~ AuthenticationRequestBuilder() 
  + email(String) AuthenticationRequestBuilder
  + password(String) AuthenticationRequestBuilder
  + build() AuthenticationRequest
  + toString() String
}
class AuthenticationResponse {
  + AuthenticationResponse(String, String, String) 
  + AuthenticationResponse() 
  - String token
  - String role
  - String username
  + builder() AuthenticationResponseBuilder
  + toString() String
  + equals(Object) boolean
  # canEqual(Object) boolean
  + hashCode() int
   String token
   String username
   String role
}
class AuthenticationResponseBuilder {
  ~ AuthenticationResponseBuilder() 
  + token(String) AuthenticationResponseBuilder
  + username(String) AuthenticationResponseBuilder
  + role(String) AuthenticationResponseBuilder
  + build() AuthenticationResponse
  + toString() String
}
class AuthenticationService {
  + AuthenticationService(UserRepository, PasswordEncoder, JwtService, AuthenticationManager) 
  + register(RegisterRequest) AuthenticationResponse
  + findUser(String) boolean
  + authenticate(AuthenticationRequest) AuthenticationResponse
}
class BaseUtils {
  + BaseUtils() 
  + divideAndCeil(int, int) int
   String formattedTimeByMinutes
}
class CliConfig {
  - CliConfig() 
  - CliConfig instance
  - takeInputs(String) int
  - validateInputs(int, int) boolean
  + readFromCli() void
  - validateInputs(int) boolean
  - takeInputs(String, int, String) int
   CliConfig instance
}
class CliConfigWriter {
  + CliConfigWriter() 
  + writeConfig(CliVendorEventConfig) void
  + readConfig() CliVendorEventConfig
}
class CliVendorEventConfig {
  + CliVendorEventConfig(int, int, int, int) 
  - int totalTickets
  - int maxTicketCapacity
  - int customerRetrievalRate
  - int ticketReleaseRate
  + writeToJson() void
  + readFromJson() CliVendorEventConfig
   int customerRetrievalRate
   int maxTicketCapacity
   int totalTickets
   int ticketReleaseRate
}
class Customer {
  + Customer(long, String, String, String, boolean) 
  + Customer() 
  - String password
  - long id
  - String email
  - String name
  - boolean vip
  + hashCode() int
  # canEqual(Object) boolean
  + equals(Object) boolean
  + toString() String
   String name
   String password
   boolean vip
   long id
   String email
}
class CustomerController {
  + CustomerController(JwtService, CustomerService) 
  + getCustomer(String) ResponseEntity~CustomerDtoOut~
}
class CustomerDTO {
  + CustomerDTO() 
  + CustomerDTO(long, String, String, String, boolean) 
  - long id
  - String name
  - String password
  - String email
  - boolean vip
  + hashCode() int
  + toString() String
  # canEqual(Object) boolean
  + equals(Object) boolean
   String name
   String password
   boolean vip
   long id
   String email
}
class CustomerDtoOut {
  + CustomerDtoOut(long, String, String, boolean) 
  + CustomerDtoOut() 
  - String name
  - long id
  - boolean vip
  - String email
  # canEqual(Object) boolean
  + toString() String
  + hashCode() int
  + equals(Object) boolean
   String name
   boolean vip
   long id
   String email
}
class CustomerMapper {
  + CustomerMapper() 
  + mapToCustomer(CustomerDTO) Customer
  + mapToCustomerDto(Customer) CustomerDTO
  + mapToCustomerDtoOut(Customer) CustomerDtoOut
}
class CustomerRepository {
<<Interface>>
  + findByEmail(String) Optional~Customer~
}
class CustomerService {
<<Interface>>
  + createCustomer(CustomerDTO) void
  + getCustomerByEmail(String) CompletableFuture~CustomerDtoOut~
  + getCustomerPriority(String) boolean
  + updateCustomerPriority(String) void
}
class CustomerServiceImpl {
  + CustomerServiceImpl(CustomerRepository) 
  + createCustomer(CustomerDTO) void
  + updateCustomerPriority(String) void
  + getCustomerByEmail(String) CompletableFuture~CustomerDtoOut~
  + getCustomerPriority(String) boolean
}
class CustomerTicket {
  + CustomerTicket(String, String, int, LocalDateTime, LocalDateTime) 
  + CustomerTicket() 
  - LocalDateTime updatedAt
  - LocalDateTime createdAt
  - String eventName
  - int ticketsBought
  - String customerEmail
  + toString() String
  + hashCode() int
  + equals(Object) boolean
   LocalDateTime updatedAt
   LocalDateTime createdAt
   int ticketsBought
   String eventName
   String customerEmail
}
class CustomerTicketController {
  + CustomerTicketController(CustomerTicketService, VendorEventConfigService, UserRepository, JwtService) 
  + addCustomerTicket(String, String) ResponseEntity~CustomerTicketDtoOut~
  - getTicketRetrievalRate(String) int
  + getAllTicketsByEmail(String) ResponseEntity~List~CustomerTicketDtoOut~~
  + deleteCustomerTicket(String, String) ResponseEntity~Void~
}
class CustomerTicketDTO {
  + CustomerTicketDTO() 
  + CustomerTicketDTO(String, String, int) 
  - String eventName
  - int ticketsBought
  - String customerEmail
  + toString() String
  + equals(Object) boolean
  # canEqual(Object) boolean
  + hashCode() int
   int ticketsBought
   String eventName
   String customerEmail
}
class CustomerTicketDtoOut {
  + CustomerTicketDtoOut() 
  + CustomerTicketDtoOut(String, String, int, LocalDateTime, LocalDateTime) 
  - String customerEmail
  - int ticketsBought
  - LocalDateTime createdAt
  - String eventName
  - LocalDateTime updatedAt
  + equals(Object) boolean
  # canEqual(Object) boolean
  + hashCode() int
  + toString() String
   LocalDateTime updatedAt
   LocalDateTime createdAt
   int ticketsBought
   String eventName
   String customerEmail
}
class CustomerTicketID {
  + CustomerTicketID(String, String) 
  + CustomerTicketID() 
  - String customerEmail
  - String eventName
  + toString() String
  + equals(Object) boolean
  + hashCode() int
   String eventName
   String customerEmail
}
class CustomerTicketMapper {
  + CustomerTicketMapper() 
  + mapToCustomerTicket(CustomerTicketDTO) CustomerTicket
  + mapToCustomerTicketDtoOut(CustomerTicket) CustomerTicketDtoOut
}
class CustomerTicketRecordDTO {
  + CustomerTicketRecordDTO(String, long) 
  + CustomerTicketRecordDTO() 
  - String eventName
  - long totalTicketsBought
  + equals(Object) boolean
  # canEqual(Object) boolean
  + hashCode() int
  + toString() String
   String eventName
   long totalTicketsBought
}
class CustomerTicketRepository {
<<Interface>>
  + existsById(CustomerTicketID) boolean
  + findTotalTicketsBoughtByCustomerEmail(String) Integer
  + findTotalTicketsBoughtGroupedByEvent() List~CustomerTicketRecordDTO~
  + findById(CustomerTicketID) Optional~CustomerTicket~
  + getCustomerTicketByCustomerEmail(String, Sort) List~CustomerTicket~
}
class CustomerTicketService {
<<Interface>>
  + deleteCustomerTickets(CustomerTicketID) CompletableFuture~Void~
  + existsById(CustomerTicketID) boolean
  + updateTicket(CustomerTicketID, int) CompletableFuture~CustomerTicketDtoOut~
  + updateCustomerTicket(CustomerTicketID, CustomerTicketDTO, int) CompletableFuture~CustomerTicketDtoOut~
  + getCustomerTicketByCustomerTicketID(CustomerTicketID) CustomerTicketDtoOut
  + getCustomerTicketsByEmail(String) CompletableFuture~List~CustomerTicketDtoOut~~
  + createCustomerTicket(CustomerTicketDTO) CompletableFuture~CustomerTicketDtoOut~
}
class CustomerTicketServiceImpl {
  + CustomerTicketServiceImpl(CustomerTicketRepository, Executor, CustomerService) 
  + getCustomerTicketByCustomerTicketID(CustomerTicketID) CustomerTicketDtoOut
  + createCustomerTicket(CustomerTicketDTO) CompletableFuture~CustomerTicketDtoOut~
  + deleteCustomerTickets(CustomerTicketID) CompletableFuture~Void~
  + updateTicket(CustomerTicketID, int) CompletableFuture~CustomerTicketDtoOut~
  + existsById(CustomerTicketID) boolean
  + getCustomerTicketsByEmail(String) CompletableFuture~List~CustomerTicketDtoOut~~
  + updateCustomerTicket(CustomerTicketID, CustomerTicketDTO, int) CompletableFuture~CustomerTicketDtoOut~
}
class DefaultController {
  + DefaultController() 
  + handleOptions() ResponseEntity~?~
  + hello() String
}
class DemoController {
  + DemoController(JwtService, UserRepository) 
  + hello(String) ResponseEntity~String~
}
class ExceptionHandler {
  + ExceptionHandler() 
  # handleMethodArgumentNotValid(MethodArgumentNotValidException, HttpHeaders, HttpStatusCode, WebRequest) ResponseEntity~Object~?
  + handleException(Exception) ResponseEntity~HttpErrorResponse~
}
class GlobalCorsConfig {
  + GlobalCorsConfig() 
  + corsFilter() CorsFilter
}
class History {
  + History(LocalDate, long, long) 
  + History() 
  - LocalDate date
  - long totalSales
  - long totalUsers
  + toString() String
  + equals(Object) boolean
  # canEqual(Object) boolean
  + hashCode() int
   LocalDate date
   long totalUsers
   long totalSales
}
class HistoryRepository {
<<Interface>>

}
class HttpErrorResponse {
  + HttpErrorResponse() 
  - int status
  - String message
  - List~String~ generalErrors
  - Map~String, String~ errors
  + of(String, int, Map~String, String~, List~String~) HttpErrorResponse
  + of(String, int) HttpErrorResponse
   List~String~ generalErrors
   Map~String, String~ errors
   String message
   int status
}
class IllegalResourceException {
  + IllegalResourceException(String) 
}
class JwtAuthenticationFilter {
  + JwtAuthenticationFilter(JwtService, UserDetailsService) 
  # doFilterInternal(HttpServletRequest, HttpServletResponse, FilterChain) void
}
class JwtService {
  + JwtService() 
  + extractAllClaims(String) Claims
  - isTokenExpired(String) boolean
  + generateToken(UserDetails) String
  - extractExpiration(String) Date
  + isTokenValid(String, UserDetails) boolean
  + generateToken(Map~String, Object~, UserDetails) String
  + extractUserEmail(String) String
  + extractClaim(String, Function~Claims, T~) T
   SecretKey signInKey
}
class LoggingAspect {
  + LoggingAspect() 
  + logMethodExecution(JoinPoint) void
}
class MethodLogger
class PriorityTask~V~ {
  + PriorityTask(int, Callable~V~) 
  - CompletableFuture~V~ future
  - int priority
  + run() void
   int priority
   CompletableFuture~V~ future
}
class RecordDTO {
  + RecordDTO(LocalDate, long, long) 
  + RecordDTO() 
  - LocalDate date
  - long totalUsers
  - long totalSales
  + toString() String
  + equals(Object) boolean
  # canEqual(Object) boolean
  + hashCode() int
   LocalDate date
   long totalUsers
   long totalSales
}
class RegisterRequest {
  + RegisterRequest() 
  + RegisterRequest(String, String, String, String) 
  - String role
  - String email
  - String password
  - String name
  # canEqual(Object) boolean
  + toString() String
  + builder() RegisterRequestBuilder
  + hashCode() int
  + equals(Object) boolean
   String name
   String password
   String email
   String role
}
class RegisterRequestBuilder {
  ~ RegisterRequestBuilder() 
  + name(String) RegisterRequestBuilder
  + email(String) RegisterRequestBuilder
  + password(String) RegisterRequestBuilder
  + role(String) RegisterRequestBuilder
  + build() RegisterRequest
  + toString() String
}
class ResourceCapacityException {
  + ResourceCapacityException(String) 
}
class ResourceNotFoundException {
  + ResourceNotFoundException(String) 
}
class Role {
<<enumeration>>
  + Role() 
  + values() Role[]
  + valueOf(String) Role
}
class Sales {
  + Sales(LocalDate, String, long) 
  + Sales() 
  - long ticketSales
  - LocalDate date
  - String vendor
  + equals(Object) boolean
  + toString() String
  # canEqual(Object) boolean
  + hashCode() int
   LocalDate date
   long ticketSales
   String vendor
}
class SalesID {
  + SalesID(LocalDate, String) 
  + SalesID() 
  - String vendor
  - LocalDate date
  + hashCode() int
  + toString() String
  + equals(Object) boolean
   LocalDate date
   String vendor
}
class SalesRepository {
<<Interface>>
  + getTotalSalesByDate(LocalDate) Integer
}
class SecurityConfig {
  + SecurityConfig(JwtAuthenticationFilter, AuthenticationProvider) 
  + securityFilterChain(HttpSecurity) SecurityFilterChain
  + corsConfigurationSource() CorsConfigurationSource
}
class SimulateController {
  + SimulateController(SimulateService) 
  + simulateOperations(int, int, int) String
}
class SimulateService {
<<Interface>>
  + checkEventExistence(String) boolean
  + addTickets(String, int, int) void
  + getToken(String) String
  + createEvent(String, String) void
  + checkUserExistence(String) boolean
  + simulate(int, int, int) boolean
  + createCustomer(String) String
  + buyTickets(String, String, int) void
  + createVendor(String) String
  + runSimulation(int, int) void
}
class SimulateServiceImpl {
  + SimulateServiceImpl(VendorService, CustomerService, UserService, VendorEventConfigService, CustomerTicketService, PasswordEncoder, AuthenticationService, List~String~, List~String~) 
  + createEvent(String, String) void
  + addTickets(String, int, int) void
  + createCustomer(String) String
  + simulate(int, int, int) boolean
  + runSimulation(int, int) void
  + getToken(String) String
  + checkUserExistence(String) boolean
  + checkEventExistence(String) boolean
  + buyTickets(String, String, int) void
  + createVendor(String) String
}
class StartupConfigurator {
  + StartupConfigurator(StatService) 
  + run(ApplicationArguments) void
}
class StatService {
<<Interface>>
  + checkSalesRecordExistence(String) CompletableFuture~Boolean~
  + updateSalesRecord(String, int) void
  + checkHistoryRecordExistence() CompletableFuture~Boolean~
  + updateHistoryRecord() void
  + createSalesRecord(String, int) void
  + createHistoryRecord() void
   CompletableFuture~RecordDTO~ recordSkeletonForToday
   CompletableFuture~TotalTicketsTimeDtoOut~ ticketPoolStats
   CompletableFuture~List~RecordDTO~~ historyRecords
   CompletableFuture~List~CustomerTicketRecordDTO~~ customerTicketPoolStats
}
class StatServiceImpl {
  + StatServiceImpl(VendorEventConfigRepository, CustomerTicketRepository, HistoryRepository, SalesRepository, UserRepository) 
  + createSalesRecord(String, int) void
  + createHistoryRecord() void
  + checkHistoryRecordExistence() CompletableFuture~Boolean~
  + updateHistoryRecord() void
  + updateSalesRecord(String, int) void
  + checkSalesRecordExistence(String) CompletableFuture~Boolean~
   CompletableFuture~RecordDTO~ recordSkeletonForToday
   CompletableFuture~TotalTicketsTimeDtoOut~ ticketPoolStats
   CompletableFuture~List~RecordDTO~~ historyRecords
   CompletableFuture~List~CustomerTicketRecordDTO~~ customerTicketPoolStats
}
class StatsController {
  + StatsController(StatService, JwtService, UserRepository) 
  + getTotalTicketPoolStats(String) ResponseEntity~TotalTicketsTimeDtoOut~
  + getHistoryRecords(String) ResponseEntity~List~RecordDTO~~
  + getCustomerTicketRecords(String) ResponseEntity~List~CustomerTicketRecordDTO~~
}
class StatsMapper {
  + StatsMapper() 
  + mapToSalesID(LocalDate, String) SalesID
  + mapToTotalTicketsTimeDtoOut(String, int, int) TotalTicketsTimeDtoOut
  + mapToSales(SalesID, long) Sales
  + mapToRecordDTO(History) RecordDTO
}
class TestEnv {
  + TestEnv() 
  + run(String[]) void
}
class ThreadController {
  + ThreadController(UserRepository, JwtService, ThreadPoolService) 
  + getAllThreadRecordsByThreadName(String, String) ResponseEntity~List~ThreadDtoOut~~
  + getAllThreadRecords(String) ResponseEntity~List~ThreadDtoOut~~
  + getCurrentThreadStatus(String) ResponseEntity~List~ThreadDtoOut~~
}
class ThreadDtoOut {
  + ThreadDtoOut() 
  + ThreadDtoOut(LocalDateTime, String, int, int, int) 
  - int totalThreads
  - LocalDateTime createdAt
  - int activeThreads
  - String name
  - int idleThreads
  + equals(Object) boolean
  + toString() String
  + hashCode() int
  # canEqual(Object) boolean
   String name
   LocalDateTime createdAt
   int totalThreads
   int activeThreads
   int idleThreads
}
class ThreadPool {
  + ThreadPool(LocalDateTime, String, Integer, Integer, Integer) 
  + ThreadPool() 
  - Integer activeThreads
  - Integer totalThreads
  - LocalDateTime createdAt
  - Integer idleThreads
  - String name
  + toString() String
  # canEqual(Object) boolean
  + hashCode() int
  + equals(Object) boolean
   String name
   Integer activeThreads
   LocalDateTime createdAt
   Integer idleThreads
   Integer totalThreads
}
class ThreadPoolConfig {
  + ThreadPoolConfig() 
  + vendorExecutor() ThreadPoolTaskExecutor
  + customerExecutor() ThreadPoolTaskExecutor
  + getActiveThreads(ThreadPoolTaskExecutor) int
  + getTotalThreads(ThreadPoolTaskExecutor) int
  + ticketExecutor() ThreadPoolTaskExecutor
  + customTaskExecutor() ThreadPoolTaskExecutor
  + getIdleThreads(ThreadPoolTaskExecutor) int
}
class ThreadPoolID {
  + ThreadPoolID(LocalDateTime, String) 
  + ThreadPoolID() 
  - String name
  - LocalDateTime createdAt
  + toString() String
  + equals(Object) boolean
  # canEqual(Object) boolean
  + hashCode() int
   String name
   LocalDateTime createdAt
}
class ThreadPoolMapper {
  + ThreadPoolMapper() 
  + mapToThreadDto(ThreadPool) ThreadDtoOut
  + mapToThreadPool(ThreadDtoOut) ThreadPool
}
class ThreadPoolRepository {
<<Interface>>
  + findLatestThreadsByName(String, PageRequest) List~ThreadPool~
  + findLatestThreads(PageRequest) List~ThreadPool~
  + findByName(String, Pageable) List~ThreadPool~
}
class ThreadPoolService {
<<Interface>>
  + getAllThreadRecordsByType(String) CompletableFuture~List~ThreadDtoOut~~
  + getStatus(ThreadPoolTaskExecutor) CompletableFuture~ArrayList~Integer~~
   CompletableFuture~List~ThreadDtoOut~~ allThreadRecords
   CompletableFuture~List~ThreadDtoOut~~ currentThreadStatus
}
class ThreadPoolServiceImpl {
  + ThreadPoolServiceImpl(ThreadPoolTaskExecutor, ThreadPoolTaskExecutor, ThreadPoolTaskExecutor, ThreadPoolTaskExecutor, ThreadPoolConfig, ThreadPoolRepository) 
  + getAllThreadRecordsByType(String) CompletableFuture~List~ThreadDtoOut~~
  + getStatus(ThreadPoolTaskExecutor) CompletableFuture~ArrayList~Integer~~
   CompletableFuture~List~ThreadDtoOut~~ allThreadRecords
   CompletableFuture~List~ThreadDtoOut~~ currentThreadStatus
}
class TicketingAppApplication {
  + TicketingAppApplication() 
  + main(String[]) void
  + startup() void
  + finish() void
  + simulate(ConfigurableApplicationContext) void
}
class TotalTicketsTimeDtoOut {
  + TotalTicketsTimeDtoOut(String, int, int) 
  + TotalTicketsTimeDtoOut() 
  - String time
  - int totalTickets
  - int totalCapacity
  + equals(Object) boolean
  + toString() String
  # canEqual(Object) boolean
  + hashCode() int
   int totalCapacity
   int totalTickets
   String time
}
class User {
  + User() 
  + User(long, String, String, String, Role, LocalDateTime) 
  - String email
  - Role role
  - String password
  - String name
  - LocalDateTime createdAt
  - long id
  + builder() UserBuilder
  # canEqual(Object) boolean
  + equals(Object) boolean
  + hashCode() int
  + toString() String
   String name
   String password
   Role role
   LocalDateTime createdAt
   long id
   String email
   Collection~GrantedAuthority~ authorities
   String username
}
class UserBuilder {
  ~ UserBuilder() 
  + id(long) UserBuilder
  + name(String) UserBuilder
  + email(String) UserBuilder
  + password(String) UserBuilder
  + role(Role) UserBuilder
  + createdAt(LocalDateTime) UserBuilder
  + build() User
  + toString() String
}
class UserController {
  + UserController(VendorService, UserRepository, JwtService, UserService) 
  + getUser(String) ResponseEntity~UserDtoOut~
  + getAllUsers(String) ResponseEntity~List~UserDtoOut~~
  + getAllVendors(String) ResponseEntity~List~UserDTO~~
}
class UserDTO {
  + UserDTO(long, String, String) 
  + UserDTO() 
  - String name
  - long id
  - String email
  + toString() String
  + equals(Object) boolean
  # canEqual(Object) boolean
  + hashCode() int
   String name
   String email
   long id
}
class UserDtoOut {
  + UserDtoOut(long, String, String, String, LocalDateTime) 
  + UserDtoOut() 
  - String role
  - LocalDateTime createdAt
  - String email
  - long id
  - String name
  + equals(Object) boolean
  # canEqual(Object) boolean
  + toString() String
  + hashCode() int
   String name
   LocalDateTime createdAt
   long id
   String email
   String role
}
class UserMapper {
  + UserMapper() 
  + mapToUserDtoOut(User) UserDtoOut
}
class UserRepository {
<<Interface>>
  + existsByEmail(String) boolean
  + findByEmail(String) Optional~User~
}
class UserService {
<<Interface>>
  + getUserByEmail(String) UserDtoOut
  + existsUserByEmail(String) Boolean
   List~UserDtoOut~ allUsers
}
class UserServiceImpl {
  + UserServiceImpl(UserRepository) 
  + existsUserByEmail(String) Boolean
  + getUserByEmail(String) UserDtoOut
   List~UserDtoOut~ allUsers
}
class Vendor {
  + Vendor(long, String, String, String) 
  + Vendor() 
  - String name
  - long id
  - String password
  - String email
  # canEqual(Object) boolean
  + toString() String
  + equals(Object) boolean
  + hashCode() int
   String name
   String password
   long id
   String email
}
class VendorController {
  + VendorController() 
}
class VendorDTO {
  + VendorDTO() 
  + VendorDTO(long, String, String, String) 
  - String name
  - long id
  - String email
  - String password
  + equals(Object) boolean
  + toString() String
  # canEqual(Object) boolean
  + hashCode() int
   String name
   String password
   long id
   String email
}
class VendorEventConfig {
  + VendorEventConfig(long, String, String, int, int, int, int) 
  + VendorEventConfig() 
  - int maxTicketCapacity
  - long id
  - int customerRetrievalRate
  - String email
  - String eventName
  - int totalTickets
  - int ticketReleaseRate
  + toString() String
  + hashCode() int
  + equals(Object) boolean
  # canEqual(Object) boolean
   String eventName
   long id
   int customerRetrievalRate
   String email
   int totalTickets
   int maxTicketCapacity
   int ticketReleaseRate
}
class VendorEventConfigController {
  + VendorEventConfigController(VendorEventConfigService, UserRepository, JwtService) 
  + getConfigsByEmail(String) ResponseEntity~List~VendorEventConfigDTO~~
  + updateVendorEventConfig(String, String, int) ResponseEntity~VendorEventConfigDTO~
  + getAllVendorEventConfigs(String) ResponseEntity~List~VendorEventConfigDTO~~
  + createConfig(String, VendorEventConfigDTOIn) ResponseEntity~VendorEventConfigDTO~
  + deleteVendorEventConfig(String, String) ResponseEntity~Object~
}
class VendorEventConfigDTO {
  + VendorEventConfigDTO(long, String, String, int, int, int, int) 
  + VendorEventConfigDTO() 
  - int maxTicketCapacity
  - long id
  - String email
  - int customerRetrievalRate
  - int totalTickets
  - String eventName
  - int ticketReleaseRate
  + toString() String
  # canEqual(Object) boolean
  + equals(Object) boolean
  + hashCode() int
   String eventName
   long id
   int customerRetrievalRate
   String email
   int totalTickets
   int maxTicketCapacity
   int ticketReleaseRate
}
class VendorEventConfigDTOIn {
  + VendorEventConfigDTOIn(long, String) 
  + VendorEventConfigDTOIn() 
  - long id
  - String eventName
  + equals(Object) boolean
  # canEqual(Object) boolean
  + hashCode() int
  + toString() String
   String eventName
   long id
}
class VendorEventConfigMapper {
  + VendorEventConfigMapper() 
  + mapToVendorEventConfigDto(VendorEventConfig) VendorEventConfigDTO
  + mapToVendorEventConfig(VendorEventConfigDTO) VendorEventConfig
  + mapFromInputSchema(CliVendorEventConfig, VendorEventConfigDTOIn, String) VendorEventConfigDTO
}
class VendorEventConfigRepository {
<<Interface>>
  + findByEventName(String) Optional~VendorEventConfig~
  + existsByEventName(String) boolean
  + findAllByEmail(String, Sort) Optional~List~VendorEventConfig~~
  + findTotalTicketPoolCapacity() Integer
  + findTotalTicketPool() Integer
  + deleteByEventName(String) void
}
class VendorEventConfigService {
<<Interface>>
  + deleteVendorEventConfig(String, String) void
  + getVendorEventConfigByEventName(String) CompletableFuture~VendorEventConfigDTO~
  + createVendorEventConfig(VendorEventConfigDTOIn, String) CompletableFuture~VendorEventConfigDTO~
  + updateTotalTickets(String, int) CompletableFuture~VendorEventConfigDTO~
  + existsByEventName(String) boolean
  + getAllVendorEventConfigsByEmail(String) CompletableFuture~List~VendorEventConfigDTO~~
  + buyTickets(String) CompletableFuture~Boolean~
   CompletableFuture~List~VendorEventConfigDTO~~ allVendorEventConfigs
}
class VendorEventConfigServiceImpl {
  + VendorEventConfigServiceImpl(VendorEventConfigRepository, StatService) 
  + createVendorEventConfig(VendorEventConfigDTOIn, String) CompletableFuture~VendorEventConfigDTO~
  + buyTickets(String) CompletableFuture~Boolean~
  + deleteVendorEventConfig(String, String) void
  + updateTotalTickets(String, int) CompletableFuture~VendorEventConfigDTO~
  + getAllVendorEventConfigsByEmail(String) CompletableFuture~List~VendorEventConfigDTO~~
  + existsByEventName(String) boolean
  + getVendorEventConfigByEventName(String) CompletableFuture~VendorEventConfigDTO~
   CompletableFuture~List~VendorEventConfigDTO~~ allVendorEventConfigs
}
class VendorMapper {
  + VendorMapper() 
  + mapToVendor(VendorDTO) Vendor
  + mapToVendorDto(Vendor) VendorDTO
  + mapToUserDto(VendorDTO) UserDTO
}
class VendorRepository {
<<Interface>>
  + existsByEmail(String) boolean
  + findByEmail(String) Optional~Vendor~
}
class VendorService {
<<Interface>>
  + getVendorByEmail(String) VendorDTO
  + createVendor(VendorDTO) void
   List~VendorDTO~ allVendors
}
class VendorServiceImpl {
  + VendorServiceImpl(VendorRepository) 
  + getVendorByEmail(String) VendorDTO
  + createVendor(VendorDTO) void
   List~VendorDTO~ allVendors
}
class WebConfig {
  + WebConfig() 
  + addCorsMappings(CorsRegistry) void
}

AdminDTO  -->  UserDTO 
AdminMapper  ..>  Admin : «create»
AdminMapper  ..>  AdminDTO : «create»
AdminMapper  ..>  UserDTO : «create»
AdminServiceImpl "1" *--> "adminRepository 1" AdminRepository 
AdminServiceImpl  ..>  AdminService 
AdminServiceImpl  ..>  ResourceNotFoundException : «create»
AppConfig "1" *--> "repository 1" UserRepository 
AuthenticationController  ..>  AdminDTO : «create»
AuthenticationController "1" *--> "adminService 1" AdminService 
AuthenticationController "1" *--> "service 1" AuthenticationService 
AuthenticationController  ..>  CustomerDTO : «create»
AuthenticationController "1" *--> "customerService 1" CustomerService 
AuthenticationController  ..>  IllegalResourceException : «create»
AuthenticationController  ..>  VendorDTO : «create»
AuthenticationController "1" *--> "vendorService 1" VendorService 
AuthenticationRequest  -->  AuthenticationRequestBuilder 
AuthenticationResponse  -->  AuthenticationResponseBuilder 
AuthenticationService  ..>  IllegalResourceException : «create»
AuthenticationService "1" *--> "jwtService 1" JwtService 
AuthenticationService  ..>  ResourceNotFoundException : «create»
AuthenticationService "1" *--> "repository 1" UserRepository 
CliConfig  ..>  CliVendorEventConfig : «create»
CustomerController "1" *--> "customerService 1" CustomerService 
CustomerController "1" *--> "jwtService 1" JwtService 
CustomerDTO  -->  UserDTO 
CustomerMapper  ..>  Customer : «create»
CustomerMapper  ..>  CustomerDTO : «create»
CustomerMapper  ..>  CustomerDtoOut : «create»
CustomerServiceImpl "1" *--> "customerRepository 1" CustomerRepository 
CustomerServiceImpl  ..>  CustomerService 
CustomerServiceImpl  ..>  ResourceNotFoundException : «create»
CustomerTicketController  ..>  CustomerTicketDTO : «create»
CustomerTicketController  ..>  CustomerTicketID : «create»
CustomerTicketController "1" *--> "customerTicketService 1" CustomerTicketService 
CustomerTicketController "1" *--> "jwtService 1" JwtService 
CustomerTicketController  ..>  ResourceNotFoundException : «create»
CustomerTicketController "1" *--> "userRepository 1" UserRepository 
CustomerTicketController "1" *--> "vendorEventConfigService 1" VendorEventConfigService 
CustomerTicketMapper  ..>  CustomerTicket : «create»
CustomerTicketMapper  ..>  CustomerTicketDtoOut : «create»
CustomerTicketServiceImpl "1" *--> "customerService 1" CustomerService 
CustomerTicketServiceImpl "1" *--> "customerTicketRepository 1" CustomerTicketRepository 
CustomerTicketServiceImpl  ..>  CustomerTicketService 
CustomerTicketServiceImpl  ..>  PriorityTask~V~ : «create»
CustomerTicketServiceImpl  ..>  ResourceNotFoundException : «create»
DemoController "1" *--> "jwtService 1" JwtService 
DemoController  ..>  ResourceNotFoundException : «create»
DemoController "1" *--> "repository 1" UserRepository 
JwtAuthenticationFilter "1" *--> "jwtService 1" JwtService 
RegisterRequest  -->  RegisterRequestBuilder 
SecurityConfig "1" *--> "jwtAuthFilter 1" JwtAuthenticationFilter 
SimulateController "1" *--> "simulateService 1" SimulateService 
SimulateServiceImpl  ..>  AuthenticationRequest : «create»
SimulateServiceImpl "1" *--> "authService 1" AuthenticationService 
SimulateServiceImpl  ..>  CustomerDTO : «create»
SimulateServiceImpl "1" *--> "customerService 1" CustomerService 
SimulateServiceImpl  ..>  CustomerTicketDTO : «create»
SimulateServiceImpl  ..>  CustomerTicketID : «create»
SimulateServiceImpl "1" *--> "customerTicketService 1" CustomerTicketService 
SimulateServiceImpl  ..>  RegisterRequest : «create»
SimulateServiceImpl  ..>  SimulateService 
SimulateServiceImpl "1" *--> "userService 1" UserService 
SimulateServiceImpl  ..>  VendorDTO : «create»
SimulateServiceImpl  ..>  VendorEventConfigDTOIn : «create»
SimulateServiceImpl "1" *--> "vendorEventConfigService 1" VendorEventConfigService 
SimulateServiceImpl "1" *--> "vendorService 1" VendorService 
StartupConfigurator "1" *--> "statService 1" StatService 
StatServiceImpl "1" *--> "customerTicketRepository 1" CustomerTicketRepository 
StatServiceImpl  ..>  History : «create»
StatServiceImpl "1" *--> "historyRepository 1" HistoryRepository 
StatServiceImpl  ..>  RecordDTO : «create»
StatServiceImpl  ..>  ResourceNotFoundException : «create»
StatServiceImpl "1" *--> "salesRepository 1" SalesRepository 
StatServiceImpl  ..>  StatService 
StatServiceImpl "1" *--> "userRepository 1" UserRepository 
StatServiceImpl "1" *--> "vendorEventConfigRepository 1" VendorEventConfigRepository 
StatsController "1" *--> "jwtService 1" JwtService 
StatsController  ..>  ResourceNotFoundException : «create»
StatsController "1" *--> "statService 1" StatService 
StatsController "1" *--> "repository 1" UserRepository 
StatsMapper  ..>  RecordDTO : «create»
StatsMapper  ..>  Sales : «create»
StatsMapper  ..>  SalesID : «create»
StatsMapper  ..>  TotalTicketsTimeDtoOut : «create»
ThreadController "1" *--> "jwtService 1" JwtService 
ThreadController  ..>  ResourceNotFoundException : «create»
ThreadController "1" *--> "threadPoolService 1" ThreadPoolService 
ThreadController "1" *--> "userRepository 1" UserRepository 
ThreadPoolConfig "1" *--> "cliVendorEventConfig 1" CliVendorEventConfig 
ThreadPoolMapper  ..>  ThreadDtoOut : «create»
ThreadPoolMapper  ..>  ThreadPool : «create»
ThreadPoolServiceImpl  ..>  ThreadDtoOut : «create»
ThreadPoolServiceImpl "1" *--> "threadPoolConfig 1" ThreadPoolConfig 
ThreadPoolServiceImpl "1" *--> "threadRepository 1" ThreadPoolRepository 
ThreadPoolServiceImpl  ..>  ThreadPoolService 
User "1" *--> "role 1" Role 
User  -->  UserBuilder 
UserController "1" *--> "jwtService 1" JwtService 
UserController  ..>  ResourceNotFoundException : «create»
UserController "1" *--> "repository 1" UserRepository 
UserController "1" *--> "userService 1" UserService 
UserController "1" *--> "vendorService 1" VendorService 
UserMapper  ..>  UserDtoOut : «create»
UserServiceImpl  ..>  ResourceNotFoundException : «create»
UserServiceImpl "1" *--> "userRepository 1" UserRepository 
UserServiceImpl  ..>  UserService 
VendorDTO  -->  UserDTO 
VendorEventConfigController "1" *--> "jwtService 1" JwtService 
VendorEventConfigController  ..>  ResourceNotFoundException : «create»
VendorEventConfigController "1" *--> "repository 1" UserRepository 
VendorEventConfigController "1" *--> "vendorEventConfigService 1" VendorEventConfigService 
VendorEventConfigDTO  -->  VendorEventConfigDTOIn 
VendorEventConfigMapper  ..>  VendorEventConfig : «create»
VendorEventConfigMapper  ..>  VendorEventConfigDTO : «create»
VendorEventConfigServiceImpl  ..>  ResourceCapacityException : «create»
VendorEventConfigServiceImpl  ..>  ResourceNotFoundException : «create»
VendorEventConfigServiceImpl "1" *--> "statService 1" StatService 
VendorEventConfigServiceImpl "1" *--> "vendorEventConfigRepository 1" VendorEventConfigRepository 
VendorEventConfigServiceImpl  ..>  VendorEventConfigService 
VendorMapper  ..>  UserDTO : «create»
VendorMapper  ..>  Vendor : «create»
VendorMapper  ..>  VendorDTO : «create»
VendorServiceImpl  ..>  ResourceNotFoundException : «create»
VendorServiceImpl "1" *--> "vendorRepository 1" VendorRepository 
VendorServiceImpl  ..>  VendorService 


```

## JWT Authentication

[![auth](https://mermaid.ink/img/pako:eNqFVFFv2jAQ_iuWnzaNQkJIAD9UmsqqblqlrrBNmngx9kGsBjuzna6s4r_PTgyFJtvygMjdfffdZ3-5Z8wUB0ywgZ8VSAYzQTeabpcSuaek2gomSiotuioESNuOf_q-eF_Z_FoUFnRneg76UTBo574a0DOwVBTmrzVzYJUWdtfOzIQpqWU5aA8uoGO2KyWtVkXRNdiMWrqixlE2uUbfxeXluzNFxE0gObpZLO7QvT8jE3jOqhzsFeoqB_bgi9BCPUDgaH5pYdGtMEbIDVIafZSPtBDc1zb5dnfXvhmPNIOMogS9uVZ6JTgH-baBQWEAfftfq0ZfOG7S1FMLrycNwFDnUe3LIuizory-RRQyL-B2uVdxccrdDTxhDYDTY230eeTpiXbKPDjHEZW1xEPAuwKe7I0q-KGNfw7pLtp5xRgYs5T_4Gv5kaA7asyxLwq8Ly1aCN_mxbMEuSv-RTU_N15t1mNRzRysTNCXCvTuxNpHphCptZ0y3IOttKzznd19fYewALsHUyp5RtSS9Nq7wyhCb8J5HpwruT9Z3MNb0FsquNtHzz61xDaHLSwxcX851Q9LvJR7V0crq-Y7yTCxuoIeruobDrvrPPiBC6s0Jmvqvo8eLpxlwb0-Y7sr_eLbCGNdR6bkWmx8vNKFC-fWloYMBj7d3wibV6s-U9uBETx3WyR_nGaDbJhN6DCBbJzQNEk4W8XTyXo4itd8HMVDivf7HnbLxnd9wmQS9aN0GE-SNEvSZDRJe3iHSRz141GWxaPRNPHhzGF-K-VURP3pOIsn0zTN0mScRWMHgFrNbbOz69Xdw1pVm_wo0PH9qOH1-_4PXujrmQ?type=png)](https://mermaid.live/edit#pako:eNqFVFFv2jAQ_iuWnzaNQkJIAD9UmsqqblqlrrBNmngx9kGsBjuzna6s4r_PTgyFJtvygMjdfffdZ3-5Z8wUB0ywgZ8VSAYzQTeabpcSuaek2gomSiotuioESNuOf_q-eF_Z_FoUFnRneg76UTBo574a0DOwVBTmrzVzYJUWdtfOzIQpqWU5aA8uoGO2KyWtVkXRNdiMWrqixlE2uUbfxeXluzNFxE0gObpZLO7QvT8jE3jOqhzsFeoqB_bgi9BCPUDgaH5pYdGtMEbIDVIafZSPtBDc1zb5dnfXvhmPNIOMogS9uVZ6JTgH-baBQWEAfftfq0ZfOG7S1FMLrycNwFDnUe3LIuizory-RRQyL-B2uVdxccrdDTxhDYDTY230eeTpiXbKPDjHEZW1xEPAuwKe7I0q-KGNfw7pLtp5xRgYs5T_4Gv5kaA7asyxLwq8Ly1aCN_mxbMEuSv-RTU_N15t1mNRzRysTNCXCvTuxNpHphCptZ0y3IOttKzznd19fYewALsHUyp5RtSS9Nq7wyhCb8J5HpwruT9Z3MNb0FsquNtHzz61xDaHLSwxcX851Q9LvJR7V0crq-Y7yTCxuoIeruobDrvrPPiBC6s0Jmvqvo8eLpxlwb0-Y7sr_eLbCGNdR6bkWmx8vNKFC-fWloYMBj7d3wibV6s-U9uBETx3WyR_nGaDbJhN6DCBbJzQNEk4W8XTyXo4itd8HMVDivf7HnbLxnd9wmQS9aN0GE-SNEvSZDRJe3iHSRz141GWxaPRNPHhzGF-K-VURP3pOIsn0zTN0mScRWMHgFrNbbOz69Xdw1pVm_wo0PH9qOH1-_4PXujrmQ)

## 🎫 Real-Time Event Ticketing System Checklist

- [x] **Accept User Prompts at Launch**
  Prompt users for configuration options before application startup.

- [x] **Error Handling and Input Validation**
  Ensure robust error handling and validation for all user inputs.

- [ ] **Start and Stop Functionality via CLI Buttons**
  Implement CLI commands to easily start and stop the system.

- [ ] **Default Configuration Feature**
  Provide a fallback configuration to use when custom settings are not specified.

- [ ] **Dynamic Configuration Feature (Optional)**
  Allow for real-time, customizable configurations during runtime.

- [ ] **Documentation for CLI Usage and Config Options**
  Provide clear documentation for all available CLI commands and configuration options.

- [ ] **Javadoc for All Classes and Methods**
  Ensure comprehensive Javadoc documentation is provided for maintainability.

  ## 🚀 Getting Started

  ### Prerequisites

  - Java 21 or higher
  - Maven 3.6.3 or higher
  - PostgreSQL 13 or higher

  ### Installation

  1. Clone the repository:

      ```shell
      git clone https://github.com/anuja-rahul/ticketingApp.git

      cd ticketingApp
      ```

  2. Configure the database in application.properties:

      ```properties
      spring.datasource.url=jdbc:postgresql://localhost:5432/ticketingapp
      spring.datasource.username=yourUsername
      spring.datasource.password=yourPassword
      ```

  3. Build the project:

      ```shell
      mvn clean install
      ```

  4. Run the application:

      ```shell
      mvn spring-boot:run
      ```

  ### Running Tests

  To run the tests, use the following command:

  ```shell
  mvn test
  ```

  ### Usage

  After starting the application, you can access the API at `http://localhost:8080/api`.

  ## 📄 License

  This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

