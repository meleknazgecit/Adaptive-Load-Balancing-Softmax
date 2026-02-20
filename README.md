# Softmax Tabanlı Adaptif Yük Dengeleme

## Proje Açıklaması

Bu projede, non-stationary (zamanla değişen) bir ortamda üç farklı yük dengeleme algoritması karşılaştırılmıştır:

- **Random (Rastgele) Yük Dengeleme**
- **Round Robin Yük Dengeleme**
- **Softmax (Multi-Armed Bandit) Tabanlı Adaptif Yük Dengeleme**

Amaç, dinamik olarak değişen sunucu gecikmeleri altında hangi algoritmanın daha düşük toplam latency ürettiğini analiz etmektir.

---

## Problem Tanımı

Dağıtık sistemlerde doğru sunucuyu seçmek, gecikmeyi minimize etmek açısından kritik öneme sahiptir.

Gerçek sistemlerde:

- Sunucu performansı zamanla değişir.
- Ağ koşulları dalgalanır.
- Latency değerleri sabit değildir.

Bu projede bu durum simüle edilmiştir.

---

## Kullanılan Algoritmalar

### 1- Random Load Balancer
- Sunucuyu rastgele seçer.
- Öğrenme mekanizması yoktur.
- Zaman karmaşıklığı: **O(1)**

---

### 2️- Round Robin Load Balancer
- Sunucuları sırayla seçer.
- Deterministik çalışır.
- Performansa göre adapte olmaz.
- Zaman karmaşıklığı: **O(1)**

---

### 3️- Softmax (Multi-Armed Bandit) Load Balancer
- Olasılıksal seçim yapar.
- Exploration – Exploitation dengesi sağlar.
- Artımsal ortalama ile öğrenir.
- Temperature (τ) parametresi keşif oranını belirler

---

## Simülasyon Ortamı

- Her sunucu latency üretir
- Gaussian gürültü eklenir
- Küçük bir drift ile non-stationary yapı oluşturulur
- Ödül fonksiyonu: reward = -latency
- Toplam latency karşılaştırma metriği olarak kullanılır.

 ---

## Örnek Deney Sonucu


-Random Total Latency: 68688
-Round Robin Total Latency: 69791
-Softmax Total Latency: 54950

Softmax algoritması en düşük toplam gecikmeyi üretmiştir.

---

## Sonuç

Non-stationary ortamlarda adaptif öğrenme temelli yöntemler, statik yöntemlere göre daha başarılıdır.

Softmax tabanlı yaklaşım, sistem dinamiklerine uyum sağlayarak toplam gecikmeyi azaltmıştır.
