# **Hướng dẫn Git lần đầu và các lần làm việc sau trên Android Studio**

## **1. Lần đầu lấy (Clone) dự án về máy**

Chỉ thực hiện 1 lần khi chưa có project trên máy.

**Bước 1:** Mở Android Studio → chọn **Get from VCS** (hoặc File → New → Project from Version Control).

**Bước 2:** Truy cập GitHub, vào repository của nhóm → nhấn **Code** → Copy link HTTPS: https://github.com/nguyenngoc218/BTLPTUDD_NHOM11.git

**Bước 3:** Quay lại Android Studio, dán link vào ô URL → chọn thư mục lưu project ở Local Path → nhấn **Clone**.

**Bước 4:** Chờ tải code về → Android Studio mở project → đợi Gradle Sync chạy xong.

**Bước 5:** Kiểm tra project đã chạy được chưa (Run app thử nếu cần).

## **2. Kiểm tra nhánh hiện tại**

Sau khi Clone, kiểm tra xem mình đang ở nhánh nào.

- Nhìn góc dưới bên phải Android Studio để xem tên branch.
- Hoặc vào **Git → Branches**.

Ví dụ nhóm có các nhánh:

| Nhánh           | Mục đích                      |
| --------------- | ----------------------------- |
| `main`          | Nhánh code chính, ổn định     |
| `develop`       | Nhánh code chung để tích hợp  |
| `Quynh`         | Nhánh làm của Quỳnh           |
| `feature/home`  | Nhánh làm giao diện trang chủ |

## **3. Chuyển sang nhánh cá nhân để làm việc**

Không nên code trực tiếp trên main hoặc develop nếu nhóm đã phân chia nhánh riêng.

**Bước 1:** Nhấn vào tên branch ở góc dưới bên phải.

**Bước 2:** Chọn nhánh muốn chuyển sang.

- Nếu nhánh đã có sẵn → chọn nhánh đó → **Checkout**.
- Nếu chưa có nhánh → chọn `New Branch` → đặt tên nhánh.

Ví dụ:

```
feature/login
feature/booking
feature/profile
```

**Bước 3:** Kiểm tra tên branch ở góc dưới đã đổi đúng chưa.

> Checkout = chuyển sang làm việc trên một nhánh khác.

## **4. Trước khi bắt đầu code – Pull code mới nhất**

Trước khi làm, nên lấy code mới nhất từ nhánh chung để tránh code của mình bị cũ so với các thành viên khác.

**Bước 1:** Chuyển về nhánh tích hợp chung mà nhóm quy định, ví dụ `develop`.

**Bước 2:** Chọn **Git → Pull**.

**Bước 3:** Chọn remote/branch cần lấy (nếu Android Studio yêu cầu) → Pull.

**Bước 4:** Đợi cập nhật xong, kiểm tra code mới.

## **5. Merge code từ nhánh chung vào nhánh cá nhân**

Ví dụ: bạn đang làm `feature/login`, nhưng các thành viên khác đã cập nhật code vào `develop`. Bạn muốn lấy code mới đó về nhánh của mình.

Quy trình merge

**develop**

Code mới nhất

**feature/login**

Nhánh đang làm

**Các bước thực hiện:**

1. Checkout sang nhánh `develop`.
2. Chọn **Git → Pull** để lấy code mới nhất.
3. Checkout lại nhánh `feature/login`.
4. Chọn **Git → Merge** (hoặc Git → Branches → chọn `develop` → Merge into Current).
5. Chọn nhánh `develop` để merge vào nhánh hiện tại.
6. Nếu có conflict (xung đột code), Android Studio sẽ mở công cụ giải quyết conflict.
7. Xử lý xong → kiểm tra lại code → chạy thử project.

> **Lưu ý:** Merge `develop` vào `feature/login` nghĩa là đưa code mới của `develop` vào nhánh `feature/login`, không làm thay đổi nhánh `develop`.

## **6. Commit code sau khi làm xong**

Sau khi hoàn thành chức năng hoặc một phần công việc:

**Bước 1:** Chọn **Git → Commit** hoặc mở tab Commit.

**Bước 2:** Kiểm tra những file được chọn để commit, tránh commit file không liên quan.

**Bước 3:** Viết nội dung commit dễ hiểu.

Ví dụ:

```
feat: create login screen
fix: validate login form
update: connect login with firebase
```

**Bước 4:** Nhấn **Commit** hoặc **Commit and Push** nếu muốn đẩy lên Git luôn.

## **7. Push code lên Git**

Push là đưa code từ máy cá nhân lên repository GitHub.

Nếu chỉ Commit:

1. Chọn **Git → Push**.
2. Kiểm tra nhánh đích.
3. Nhấn **Push**.

Code sẽ được đẩy lên nhánh cá nhân của bạn.

## **8. Tạo Pull Request để merge code vào nhánh chung**

Khi hoàn thành chức năng:

1. Push nhánh cá nhân lên GitHub.
2. Mở repository trên GitHub.
3. Chọn **Pull requests → New pull request**.
4. Chọn:
   - **Base:** `develop` (nhánh nhận code).
   - **Compare:** `feature/login` (nhánh code của bạn).
5. Kiểm tra phần thay đổi.
6. Tạo Pull Request để nhóm review.
7. Sau khi được duyệt thì Merge vào `develop`.

Ví dụ luồng code

**feature/login**

Code chức năng đăng nhập

**develop**

Nhận code sau khi review và merge

## **9. Quy trình làm việc mỗi ngày (quan trọng nhất)**

Sau lần Clone đầu tiên, những lần sau không cần Clone lại nữa.

## **Quy trình làm việc hằng ngày**

Đầu ngày / trước khi code

1\. Checkout → `develop`

2\. Pull code mới nhất

3\. Checkout → `feature/nhánh-của-mình`

4\. Merge `develop` vào nhánh cá nhân

Trong khi làm

5\. Code chức năng

6\. Commit theo từng phần nhỏ

7\. Push nhánh cá nhân lên Git

Khi hoàn thành chức năng

8\. Tạo Pull Request → Review → Merge vào `develop`

## **10. Những lệnh Git tương ứng để dễ nhớ**

| Thao tác       | Lệnh Git          | Ý nghĩa                                |
| -------------- | ----------------- | -------------------------------------- |
| Clone          | `git clone`       | Lấy dự án về máy lần đầu               |
| Kiểm tra nhánh | `git branch`      | Xem các nhánh                          |
| Chuyển nhánh   | `git checkout`    | Chuyển sang nhánh khác                 |
| Tạo nhánh      | `git checkout -b` | Tạo và chuyển sang nhánh mới           |
| Pull           | `git pull`        | Lấy code mới về                        |
| Merge          | `git merge`       | Gộp code nhánh khác vào nhánh hiện tại |
| Commit         | `git commit`      | Lưu phiên bản code                     |
| Push           | `git push`        | Đẩy code lên GitHub                    |

