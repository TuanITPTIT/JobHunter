# CHƯƠNG II. KIẾN THỨC ÁP DỤNG

## 2.1. Cơ sở dữ liệu

Trong hệ thống **JobHunter**, cơ sở dữ liệu đóng vai trò trung tâm trong việc lưu trữ, truy xuất và quản lý dữ liệu để hỗ trợ các chức năng nghiệp vụ của ứng dụng tìm kiếm việc làm. Hệ quản trị cơ sở dữ liệu được lựa chọn là **MySQL**, một hệ quản trị cơ sở dữ liệu quan hệ (RDBMS) phổ biến, phù hợp với các ứng dụng web hiện đại nhờ tính ổn định, hiệu năng cao và khả năng hỗ trợ các giao dịch phức tạp.

MySQL lưu trữ dữ liệu dưới dạng các bảng quan hệ, với các hàng và cột được định nghĩa rõ ràng thông qua lược đồ (schema). Dữ liệu được tổ chức theo cấu trúc bảng, sử dụng các khóa chính và khóa ngoại để đảm bảo tính toàn vẹn tham chiếu và mối quan hệ giữa các thực thể. Điều này cho phép hệ thống duy trì tính nhất quán và dễ dàng thực hiện các truy vấn phức tạp thông qua ngôn ngữ SQL.

Để thao tác và tương tác với cơ sở dữ liệu MySQL, hệ thống sử dụng **Hibernate** kết hợp với **JPA (Java Persistence API)** – một công cụ ORM (Object-Relational Mapping) mạnh mẽ trong hệ sinh thái Java. Hibernate cung cấp một lớp trừu tượng giúp định nghĩa các mô hình dữ liệu (entity) một cách rõ ràng, hỗ trợ kiểm soát dữ liệu đầu vào, ràng buộc kiểu dữ liệu, và tạo ra các phương thức truy vấn linh hoạt thông qua **JPQL** hoặc **Criteria API**. Ngoài ra, Hibernate giúp đảm bảo tính toàn vẹn và bảo mật dữ liệu trong quá trình vận hành hệ thống thông qua các cơ chế như kiểm tra ràng buộc dữ liệu, quản lý giao dịch (transaction), và xử lý ngoại lệ một cách hiệu quả.

---

## 2.2. Công nghệ và ngôn ngữ lập trình

### 2.2.1 API – Giao tiếp RESTful

**API (Application Programming Interface)** là cầu nối cho phép các hệ thống phần mềm khác nhau giao tiếp với nhau. Trong các ứng dụng web hiện đại, API thường được thiết kế theo chuẩn **REST (Representational State Transfer)** và giao tiếp thông qua giao thức HTTP. REST API giúp frontend (React) và backend (Spring Boot) tương tác hiệu quả với nhau.

Cấu trúc REST API trong hệ thống **JobHunter**:

| Phương thức | URL ví dụ | Ý nghĩa |
|-------------|-----------|---------|
| GET | `/api/v1/jobs` | Lấy danh sách việc làm |
| POST | `/api/v1/jobs` | Tạo việc làm mới |
| PUT | `/api/v1/jobs/{id}` | Cập nhật thông tin việc làm |
| DELETE | `/api/v1/jobs/{id}` | Xóa việc làm |
| POST | `/api/v1/auth/login` | Đăng nhập người dùng |

**Cách hoạt động của API:**

1. Frontend (React) gửi request HTTP đến các endpoint của Spring Boot.
2. Controller trong Spring Boot tiếp nhận và xử lý request (qua lớp Service).
3. Dữ liệu được truy xuất hoặc cập nhật từ cơ sở dữ liệu (Model).
4. Kết quả được trả về dưới dạng JSON cho frontend xử lý và hiển thị.

---

### 2.2.2 Spring Boot Framework

**Spring Boot** là một framework mạnh mẽ của Java, thuộc hệ sinh thái Spring, giúp phát triển ứng dụng Java một cách nhanh chóng và đơn giản. Nó giúp giảm thiểu việc cấu hình thủ công và tạo ra các ứng dụng độc lập, dễ triển khai.

**Tính năng chính:**

- **Auto Configuration:** Spring Boot tự động cấu hình ứng dụng dựa trên các thư viện có sẵn trong classpath mà không cần cấu hình thủ công.
- **Standalone Applications:** Các ứng dụng Spring Boot có thể chạy độc lập, không cần phải triển khai trên một máy chủ ứng dụng bên ngoài (ví dụ như Tomcat).
- **Embedded Servers:** Spring Boot tích hợp sẵn các máy chủ web như Tomcat, Jetty, hoặc Undertow.
- **Spring Boot Starter Projects:** Cung cấp các bộ công cụ tích hợp sẵn để sử dụng các tính năng phổ biến (ví dụ: Spring Data JPA, Spring Web, Spring Security).
- **Actuator:** Một công cụ giúp theo dõi và quản lý các ứng dụng Spring Boot đã triển khai.

**Lợi ích:**

- Giảm thiểu cấu hình: Spring Boot giúp bắt đầu nhanh chóng mà không cần phải cấu hình quá nhiều.
- Tính mở rộng cao: Có thể dễ dàng mở rộng và cấu hình ứng dụng khi cần thiết.
- Cộng đồng lớn: Với sự hỗ trợ của cộng đồng Spring, có rất nhiều tài liệu và ví dụ về Spring Boot.

---

### 2.2.3 React Framework

**React** là một thư viện JavaScript mã nguồn mở được phát triển bởi Facebook, được sử dụng rộng rãi để xây dựng giao diện người dùng (UI) cho các ứng dụng web hiện đại. React cho phép tạo ra các thành phần giao diện có thể tái sử dụng (reusable components) và quản lý trạng thái ứng dụng một cách hiệu quả.

**Tính năng chính:**

- **Component-Based Architecture:** React xây dựng giao diện dựa trên các component độc lập, có thể tái sử dụng và dễ bảo trì.
- **Virtual DOM:** React sử dụng Virtual DOM để tối ưu hóa quá trình cập nhật giao diện, giảm thiểu thao tác trên DOM thực và tăng hiệu suất ứng dụng.
- **JSX Syntax:** JSX cho phép viết code giao diện gần với HTML, giúp mã nguồn dễ đọc và dễ hiểu hơn.
- **Unidirectional Data Flow:** Dữ liệu trong React được truyền theo một chiều từ parent component xuống child component, giúp quản lý trạng thái ứng dụng trở nên rõ ràng và dễ debug.
- **Hooks:** React Hooks (như useState, useEffect, useContext) cho phép sử dụng state và các tính năng khác của React trong các functional component.

**Lợi ích:**

- Hiệu suất cao: Nhờ Virtual DOM và cơ chế reconciliation, React tối ưu hóa việc cập nhật giao diện.
- Tái sử dụng component: Các component có thể được sử dụng lại ở nhiều nơi trong ứng dụng.
- Cộng đồng lớn: React có cộng đồng phát triển đông đảo, nhiều thư viện hỗ trợ và tài liệu phong phú.
- Dễ học: Cú pháp JSX gần gũi với HTML, giúp lập trình viên mới dễ tiếp cận.

---

### 2.2.4 Vite Build Tool

**Vite** là một công cụ build tool thế hệ mới cho frontend, được thiết kế để cung cấp trải nghiệm phát triển nhanh chóng và hiệu quả. Vite sử dụng native ES modules trong môi trường development và bundler (Rollup) cho production build.

**Tính năng chính:**

- **Lightning Fast HMR (Hot Module Replacement):** Vite cung cấp Hot Module Replacement với tốc độ cực nhanh, chỉ cập nhật những module thực sự thay đổi mà không cần reload toàn bộ trang.
- **Instant Server Start:** Server development khởi động gần như tức thì, không cần bundling trước.
- **Optimized Production Build:** Sử dụng Rollup để tạo production build được tối ưu hóa với code splitting và tree shaking.
- **Native Support for TypeScript:** Vite có hỗ trợ TypeScript native mà không cần cấu hình phức tạp.

**Lợi ích:**

- Tốc độ phát triển nhanh: HMR tức thì giúp lập trình viên thấy ngay thay đổi mà không mất thời gian chờ đợi.
- Build nhanh: Production build được tối ưu hóa với kích thước nhỏ gọn.
- Cấu hình đơn giản: Không cần nhiều cấu hình để bắt đầu dự án.

---

### 2.2.5 TypeScript

**TypeScript** là một ngôn ngữ lập trình được phát triển bởi Microsoft, là superset của JavaScript với tính năng kiểm tra kiểu dữ liệu tĩnh (static type checking). TypeScript giúp phát triển các ứng dụng JavaScript lớn và phức tạp một cách dễ dàng và an toàn hơn.

**Tính năng chính:**

- **Static Type Checking:** TypeScript kiểm tra kiểu dữ liệu tại thời điểm biên dịch, giúp phát hiện lỗi sớm và giảm thiểu bug runtime.
- **Interface và Type Aliases:** Cho phép định nghĩa cấu trúc dữ liệu rõ ràng, tăng tính rõ ràng và tái sử dụng code.
- **Generics:** Hỗ trợ generic types cho phép viết code linh hoạt và tái sử dụng cao.
- **IDE Support:** TypeScript được hỗ trợ tốt bởi các IDE như VS Code với tính năng IntelliSense, auto-complete và refactoring.

**Lợi ích:**

- Giảm bug: Kiểm tra kiểu tĩnh giúp phát hiện lỗi sớm trong quá trình phát triển.
- Code dễ bảo trì: Cấu trúc dữ liệu rõ ràng với interface giúp code dễ đọc và maintain.
- Tự động hoàn thành: IDE hỗ trợ tốt giúp tăng năng suất lập trình.
- Refactoring an toàn: Dễ dàng thay đổi code mà không sợ break các phần khác.

---

### 2.2.6 Redux Toolkit

**Redux Toolkit** là một thư viện quản lý trạng thái (state management) cho các ứng dụng JavaScript, được thiết kế để đơn giản hóa việc sử dụng Redux. Redux Toolkit cung cấp các API và helper functions giúp giảm thiểu boilerplate code và áp dụng các best practices một cách dễ dàng.

**Tính năng chính:**

- **Slice Pattern:** Redux Toolkit định nghĩa state và logic xử lý trong một "slice" duy nhất, kết hợp action creators và reducers.
- **Immer Integration:** Cho phép viết immutable state updates một cách tự nhiên như mutable code.
- **createAsyncThunk:** Hỗ trợ xử lý asynchronous operations (API calls) một cách dễ dàng.
- **Built-in Middleware:** Tích hợp sẵn redux-thunk và cấu hình store đơn giản hơn.

**Lợi ích:**

- Giảm boilerplate: Ít code hơn so với Redux thuần.
- Tổ chức code tốt: Mỗi feature/domain có slice riêng biệt.
- Xử lý async dễ dàng: createAsyncThunk giúp quản lý loading states và errors.
- DevTools tích hợp: Hỗ trợ tốt Redux DevTools để debug.

---

### 2.2.7 JPA (Java Persistence API)

**JPA (Java Persistence API)** là một chuẩn API của Java, giúp quản lý dữ liệu trong cơ sở dữ liệu quan hệ một cách đơn giản và hiệu quả. JPA cho phép các lập trình viên làm việc với cơ sở dữ liệu mà không phải lo lắng về các chi tiết SQL, giúp giảm thiểu công sức khi tương tác với cơ sở dữ liệu.

**Tính năng chính:**

- **Entity:** JPA sử dụng các lớp entity để đại diện cho bảng trong cơ sở dữ liệu. Mỗi entity sẽ ánh xạ với một bảng trong cơ sở dữ liệu.
- **ORM (Object-Relational Mapping):** JPA sử dụng các framework ORM như Hibernate để tự động ánh xạ các đối tượng Java (Object) với các bản ghi trong cơ sở dữ liệu (Relational).
- **Queries:** JPA hỗ trợ tạo truy vấn SQL bằng cách sử dụng JPQL (Java Persistence Query Language) hoặc SQL thuần túy.
- **Transactions:** Hỗ trợ quản lý giao dịch, giúp đảm bảo tính toàn vẹn dữ liệu trong các thao tác với cơ sở dữ liệu.

**Lợi ích:**

- Dễ dàng thao tác với cơ sở dữ liệu: JPA giúp quản lý và thao tác với dữ liệu mà không cần viết quá nhiều mã SQL thủ công.
- Tự động ánh xạ giữa đối tượng Java và bảng cơ sở dữ liệu: Giúp giảm thiểu công sức và sai sót khi làm việc với cơ sở dữ liệu.
- Hỗ trợ truy vấn linh hoạt: JPA cho phép xây dựng các truy vấn động và linh hoạt.
- Hỗ trợ tính toàn vẹn dữ liệu: Quản lý giao dịch và các thao tác dữ liệu an toàn hơn.

---

### 2.2.8 Ant Design

**Ant Design** là một thư viện UI component library cho React, được phát triển bởi Ant Group (Alibaba). Ant Design cung cấp bộ sưu tập các component giao diện người dùng phong phú, được thiết kế theo nguyên tắc thiết kế enterprise-class với giao diện đẹp, nhất quán và dễ sử dụng.

**Tính năng chính:**

- **Comprehensive Components:** Ant Design cung cấp hơn 60 component UI sẵn sàng sử dụng như Button, Table, Form, Modal, Select, DatePicker, v.v.
- **Enterprise Design:** Thiết kế theo phong cách enterprise với tính nhất quán cao, phù hợp cho các ứng dụng doanh nghiệp.
- **TypeScript Support:** Được viết bằng TypeScript với đầy đủ types, hỗ trợ IntelliSense tốt.
- **Customizable Theme:** Cho phép tùy chỉnh theme (màu sắc, font, spacing) thông qua CSS variables hoặc ConfigProvider.
- **Responsive Design:** Các component được thiết kế responsive, tự động điều chỉnh theo kích thước màn hình.

**Lợi ích:**

- Phát triển nhanh: Sử dụng component có sẵn giúp giảm thời gian phát triển giao diện.
- Giao diện chuyên nghiệp: Thiết kế đẹp và nhất quán theo tiêu chuẩn enterprise.
- Documentation đầy đủ: Có tài liệu chi tiết và ví dụ phong phú.
- Community lớn: Được sử dụng rộng rãi với nhiều tài nguyên hỗ trợ.

---

### 2.2.9 Một số công nghệ khác

Ngoài những công nghệ trên, đề tài còn sử dụng một số công nghệ khác nhằm nâng cao hiệu năng và tối ưu trải nghiệm người dùng:

**JWT trong quá trình đăng nhập và phân quyền:** Áp dụng **JSON Web Token (JWT)** để xác thực người dùng sau khi đăng nhập, đồng thời kiểm soát truy cập tài nguyên theo vai trò (role) thông qua thông tin chứa trong token. Hệ thống sử dụng access token và refresh token để đảm bảo bảo mật và trải nghiệm người dùng liền mạch.

**Mã hóa mật khẩu bằng PasswordEncoder của Spring Boot:** Sử dụng **BCryptPasswordEncoder** để mã hóa mật khẩu trước khi lưu vào cơ sở dữ liệu, giúp tăng cường bảo mật và ngăn chặn rò rỉ thông tin người dùng.

**OAuth2 đăng nhập bằng Google:** Tích hợp **Spring Security OAuth2** để cho phép người dùng đăng nhập bằng tài khoản Google, giúp đơn giản hóa quá trình đăng ký và đăng nhập.

**Sử dụng Spring Mail để gửi email:** Tích hợp **Spring Mail** để gửi email tự động cho người dùng trong các tình huống như quên mật khẩu và xác nhận tài khoản, giúp tăng tính chuyên nghiệp và hỗ trợ trải nghiệm người dùng tốt hơn.

**Tích hợp AI API (Gemini và Groq):** Sử dụng **Google Gemini API** và **Groq API** để cung cấp các tính năng thông minh như:
- Chấm điểm CV tự động dựa trên mô tả công việc
- Gợi ý việc làm phù hợp với hồ sơ ứng viên
- Tạo câu hỏi phỏng vấn và đánh giá câu trả lời
- Xây dựng nội dung CV chuyên nghiệp

**Thư viện Axios cho HTTP requests:** Sử dụng **Axios** để thực hiện các HTTP requests từ frontend đến backend REST API, với các tính năng như interceptors, automatic JSON transformation, và error handling.

**SCSS cho styling:** Sử dụng **SCSS (Sass)** để viết CSS có tổ chức, hỗ trợ variables, nesting, mixins và inheritance, giúp quản lý stylesheet dễ dàng và tái sử dụng.

**React Router DOM v6:** Sử dụng **React Router DOM v6** để quản lý routing trong ứng dụng React, hỗ trợ nested routes, protected routes và dynamic routing.
